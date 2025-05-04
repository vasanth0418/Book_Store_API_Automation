package com.bookstore.utils;

import java.util.ResourceBundle;

public class ConfigManager {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static String getBaseUrl() {
        String env = System.getProperty("env", "dev");
        return bundle.containsKey(env + ".base.url") ? bundle.getString(env + ".base.url") : bundle.getString("base.url");
    }
}
