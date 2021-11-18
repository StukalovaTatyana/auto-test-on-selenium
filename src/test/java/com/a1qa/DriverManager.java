package com.a1qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("lang=en-GB");
        driver = new ChromeDriver(chromeOptions);
    }

    public static DriverManager getInstance(){
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}