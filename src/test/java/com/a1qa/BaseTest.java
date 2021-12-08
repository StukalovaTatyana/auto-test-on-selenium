package com.a1qa;

import com.a1qa.config.Configuration;
import com.a1qa.pages.AlertPage;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class BaseTest {
    private WebDriver driver;
    private MainPage mainPage;
    private AlertPage alertPage;

    @BeforeMethod
    public void setupClass() {
        driver = DriverManager.getInstance().openBrowser();
        mainPage = new MainPage();
        alertPage = new AlertPage();
    }

    @Test
    public void alertTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened());

        mainPage.clickAlertCard();
        assertTrue(alertPage.isPageOpened());

        alertPage.clickAlertListElement();
        assertTrue(alertPage.isAlertFormDisplayed());

        alertPage.clickAlertButton();
        Alert alert = alertPage.switchToAlert();
        assertNotNull(alert);
        assertEquals(alert.getText(), "You clicked a button");

        alert.accept();
        alert = alertPage.switchToAlert();
        assertNull(alert);

//        alertPage.clickAlertButtonWithDelay();
//        alert = alertPage.waitForAlert(Configuration.getDefaultMiddleTimeout());
//        assertNotNull(alert);
    }

    //@AfterMethod
    private void closeBrowser() {
        driver.quit();
    }
}
