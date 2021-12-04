package com.a1qa;

import com.a1qa.config.Configuration;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
    }

    public WebDriver openBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("lang=" + Configuration.getLang());
        chromeOptions.addArguments("--window-size="+Configuration.getScreenWidth()+","+Configuration.getScreenHeight());
        this.driver = new ChromeDriver(chromeOptions);
        /*this.driver
                .manage()
                .window()
                .setSize(new Dimension(
                        Configuration.getScreenWidth(),
                        Configuration.getScreenHeight()
                ));*/
        return this.driver;
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            ChromeDriverManager.getInstance().setup();
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
