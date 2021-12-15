package com.a1qa;

import com.a1qa.utils.Generator;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTest extends BaseTest {
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

        alertPage.clickConfirmButton();
        alert = alertPage.switchToAlert();
        assertNotNull(alert);
        assertEquals(alert.getText(), "Do you confirm action?");
        alert.accept();
        alert = alertPage.switchToAlert();
        assertNull(alert);
        String confirmResult = alertPage.getConfirmResult();
        assertEquals(confirmResult, "You selected Ok");

        alertPage.clickPromptButton();
        alert = alertPage.switchToAlert();
        assertNotNull(alert);
        assertEquals(alert.getText(), "Please enter your name");
        String text = Generator.textGenerate(5);
        alert.sendKeys(text);
        alert.accept();
        alert = alertPage.switchToAlert();
        assertNull(alert);
        assertTrue(alertPage.getPromptResult().contains(text));
    }
}
