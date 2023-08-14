package com.bbc.api.constants;

/**
 * This Class is used to set all the Static Constant Variable which can be used across the project
 *
 * @author Ragul Dhandapani
 */
public class ApplicationConstants {

    private ApplicationConstants(){}

    //cucumber options and plugin constants
    public static final String CUCUMBER_OPTIONS_FEATURES = "src/test/resources/features/";
    public static final String CUCUMBER_OPTIONS_GLUE = "com.bbc.api.cucumbertests";
    public static final String CUCUMBER_PLUGIN_PRETTY = "pretty";
    public static final String CUCUMBER_PLUGIN_JSON = "json:build/reports/cucumber-reports/cucumber-html-reports/cucumber.json";
    public static final String CUCUMBER_PLUGIN_RERUN = "rerun:build/reports/cucumber-reports/failed_scenarios.txt";

}
