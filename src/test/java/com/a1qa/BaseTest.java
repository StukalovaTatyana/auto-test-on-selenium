package com.a1qa;

import com.a1qa.config.Configuration;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BaseTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setupClass() {
        driver = DriverManager.getInstance().openBrowser();
        mainPage = new MainPage();
    }

    @Test
    public void alertTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened());

        mainPage.clickAlertCard();
        // TODO: 06.12.2021 assert alert page is open 
    }

    @AfterMethod
    private void closeBrowser() {
        driver.quit();
    }
}
