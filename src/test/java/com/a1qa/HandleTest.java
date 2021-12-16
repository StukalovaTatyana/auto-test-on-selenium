package com.a1qa;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HandleTest extends BaseTest {
    @Test
    public void handleTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened(), "The main page does not open");

        mainPage.clickAlertCard();
        assertTrue(alertPage.isPageOpened(), "The Browser Windows page does not open");

        browserWindow.clickBrowserWindowElement();
        assertTrue(browserWindow.isPageOpened(), "New tab doesn't open");

        browserWindow.clickNewTabElement();
        browserWindow.closeNewTab();
        assertTrue(browserWindow.isPageOpened(), "The Browser Windows page does not open");

        browserWindow.clickElementsList();
        browserWindow.clickLinkElement();
        assertTrue(linksPage.isPageOpened(), "New page with Links doesn't open");

        String mainHandle = driver.getWindowHandle();
        linksPage.clickSimpleLink();
        linksPage.switchToNewTab();
        assertTrue(mainPage.isPageOpened(), "The main page does not open");

        driver.switchTo().window(mainHandle);
        assertTrue(linksPage.isPageOpened(), "Page with links form doesn't open");
    }
}
