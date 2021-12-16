package com.a1qa;

import com.a1qa.framework.test.BaseTest;
import com.a1qa.framework.utils.DriverManager;
import com.a1qa.framework.utils.Generator;
import com.a1qa.pages.AlertPage;
import com.a1qa.pages.MainPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTest extends BaseTest {
    final static Logger LOGGER = Logger.getLogger(AlertTest.class.toString());

    @Test
    public void alertTest() {
        MainPage mainPage = new MainPage();

        LOGGER.info("Opening main page");
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        LOGGER.info("Try to click on the alert card");
        mainPage.clickAlertCard();
        AlertPage alertPage = new AlertPage();

        assertTrue(alertPage.waitForPageToOpenAndCheckIfOpen(), "The card is not pressed");


        alertPage.clickAlertListElement();
        assertTrue(alertPage.isAlertFormDisplayed(), "The alert doesn't show up");

        LOGGER.info("Try to click on the button 'Click Button to see alert'");
        alertPage.clickAlertButton();
        Alert alert = alertPage.switchToAlert();
        assertNotNull(alert, "The alert has closed");
        assertEquals(alert.getText(), "You clicked a button",
                "The alert with text 'You clicked a button' doesn't open");

        LOGGER.info("Try to click on the button 'OK'");
        alert.accept();
        alert = alertPage.switchToAlert();
        assertNull(alert, "The alert doesn't close");

        LOGGER.info("Try to click on the button 'On button click, confirm box will appear'");
        alertPage.clickConfirmButton();
        alert = alertPage.switchToAlert();
        assertNotNull(alert, "The alert has closed");
        assertEquals(alert.getText(), "Do you confirm action?",
                "The alert with text 'Do you confirm action?' doesn't open");

        LOGGER.info("Try to click on the button 'OK'");
        alert.accept();
        alert = alertPage.switchToAlert();
        assertNull(alert, "The alert doesn't close");
        String confirmResult = alertPage.getConfirmResult();
        assertEquals(confirmResult, "You selected Ok",
                "The inscription 'You selected Ok' does not appear next to the button");

        LOGGER.info("Try to click on the button 'On button click, prompt box will appear'");
        alertPage.clickPromptButton();
        alert = alertPage.switchToAlert();
        assertNotNull(alert, "The alert has closed");
        assertEquals(alert.getText(), "Please enter your name",
                "The alert with the text 'Please enter your name' is not open");
        String text = Generator.textGenerate(5);
        alert.sendKeys(text);
        alert.accept();

        LOGGER.info("Try to click on the button 'OK'");
        alert = alertPage.switchToAlert();
        assertNull(alert, "The alert doesn't close");
        assertTrue(alertPage.getPromptResult().contains(text));
    }
}
