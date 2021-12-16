package com.a1qa.framework.utils;

import com.a1qa.config.Configuration;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver openBrowser() {
        driver = BrowserFactory.getWebDriver();
        return driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            openBrowser();
        }
        return driver;
    }

    public static void openMainPage() {
        getInstance().get(Configuration.getUrl());
    }
}
