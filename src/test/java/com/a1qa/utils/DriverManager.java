package com.a1qa.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
    }

    public WebDriver openBrowser() {
        this.driver = BrowserFactory.getWebDriver();
        return this.driver;
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
