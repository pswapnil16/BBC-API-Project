package com.bbc.api.cucumbertests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static com.bbc.api.constants.ApplicationConstants.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = CUCUMBER_OPTIONS_FEATURES + "RMS_Get.feature",
        plugin = {CUCUMBER_PLUGIN_PRETTY , CUCUMBER_PLUGIN_JSON , CUCUMBER_PLUGIN_RERUN},
        glue = {CUCUMBER_OPTIONS_GLUE}, tags= "@RMS_API_Test")

public class RMS_GetRunner {

}
