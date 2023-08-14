package com.bbc.api.cucumbertests.definitions;
import com.bbc.api.cucumbertests.constants.TestApplicationConstants;
import com.bbc.api.executor.RequestExecutor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.bbc.api.cucumbertests.constants.TestApplicationConstants.baseUri;

public class GenericStepDefinitions extends RequestExecutor {


    @Given("the base URI is {string}")
    public void theBaseURIIs(String baseUri) {
        TestApplicationConstants.baseUri = baseUri;
    }

    @When("user send a GET request to {string}")
    public void userSendAGETRequestTo(String apiUri) {
        restResponse = performGet(baseUri + apiUri);
    }

    @When("user send a GET request to api {string}")
    public void userSendAGETRequestToApi(String apiUri) {
        response=executeGET(baseUri + apiUri);
    }

    @Then("the response status code should be {int} and reason  {string}")
    public void theResponseStatusCodeShouldBeStatus_codeAndReasonStatus_reason(int statusCode , String statusReason) {
        Assert.assertEquals(restResponse.getStatusCode(),statusCode);
        Assert.assertEquals(restResponse.getStatusLine(),statusReason);
    }

    @And("the response time of the request is below {int} milliseconds")
    public void theResponseTimeOfTheRequestIsBelowResponse_timeMilliseconds(int response_time) {
        long actualResponseTime = restResponse.getTime();
        Assert.assertTrue(restResponse.getTime()<response_time,"Response time should be less than expected but actual time is "+actualResponseTime);
    }
}
