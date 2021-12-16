package com.a1qa;

import com.a1qa.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    protected void setupClass() {
        driver = DriverManager.openBrowser();
    }

    @AfterMethod
    protected void closeBrowser() {
        driver.quit();
    }
}
