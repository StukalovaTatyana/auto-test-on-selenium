package com.a1qa;

import com.a1qa.pages.AlertPage;
import com.a1qa.pages.IframePage;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected AlertPage alertPage;
    protected IframePage iframePage;

    @BeforeMethod
    protected void setupClass() {
        driver = DriverManager.getInstance().openBrowser();
        mainPage = new MainPage();
        alertPage = new AlertPage();
        iframePage = new IframePage();
    }

    @AfterMethod
    protected void closeBrowser() {
        driver.quit();
    }
}
