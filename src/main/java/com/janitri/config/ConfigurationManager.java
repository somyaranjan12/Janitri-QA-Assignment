package com.janitri.config;

public class ConfigurationManager {
    private static final String BASE_URL = "https://dev-dash.janitri.in/";
    private static final int IMPLICIT_WAIT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 30;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static int getImplicitWait() {
        return IMPLICIT_WAIT;
    }

    public static int getPageLoadTimeout() {
        return PAGE_LOAD_TIMEOUT;
    }
}
