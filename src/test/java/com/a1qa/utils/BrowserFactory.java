package com.a1qa.utils;

import com.a1qa.config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public static WebDriver getWebDriver(){
        switch (Configuration.getBrowserName()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("lang=" + Configuration.getLang());
                chromeOptions.addArguments("--window-size="+Configuration.getScreenWidth()+","+Configuration.getScreenHeight());
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("lang=" + Configuration.getLang());
                firefoxOptions.addArguments("--window-size="+Configuration.getScreenWidth()+","+Configuration.getScreenHeight());

                return new FirefoxDriver(firefoxOptions);
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

}
