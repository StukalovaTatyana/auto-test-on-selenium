package com.a1qa;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HandleTest extends BaseTest {
    @Test
    public void handleTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened());

        mainPage.clickAlertCard();
        assertTrue(alertPage.isPageOpened());

        browserWindow.clickBrowserWindowElement();
        assertTrue(browserWindow.isPageOpened());

        browserWindow.clickNewTabElement();
        browserWindow.closeNewTab();
        assertTrue(browserWindow.isPageOpened());

        browserWindow.clickElementsList();
        browserWindow.clickLinkElement();
        assertTrue(linksPage.isPageOpened());

        String mainHandle = driver.getWindowHandle();
        linksPage.clickSimpleLink();
        linksPage.switchToNewTab();
        assertTrue(mainPage.isPageOpened());

        driver.switchTo().window(mainHandle);
        assertTrue(linksPage.isPageOpened());
    }
}
