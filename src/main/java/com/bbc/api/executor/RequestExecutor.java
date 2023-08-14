package com.bbc.api.executor;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class RequestExecutor {

    public static Response restResponse;
    public static ValidatableResponse response;

    private static RequestSpecification getRequestSpecification() {
        return given()
                .contentType(ContentType.ANY)
                .log()
                .all();

    }

    public static Response performGet(String endPoint) {
        RequestSpecification requestSpecification = getRequestSpecification();
        restResponse = requestSpecification.get(endPoint).prettyPeek();
        return restResponse;
    }

    public static ValidatableResponse executeGET(String endPoint) {

        return given().relaxedHTTPSValidation()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(endPoint)
                .then()
                .log()
                .all();
    }


}
