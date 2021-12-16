package com.a1qa;

import com.a1qa.pages.AlertPage;
import com.a1qa.pages.BrowserWindowPage;
import com.a1qa.pages.LinksPage;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HandleTest extends BaseTest {
    @Test
    public void handleTest() {
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        mainPage.clickAlertCard();
        AlertPage alertPage = new AlertPage();
        assertTrue(alertPage.waitForPageToOpenAndCheckIfOpen(), "The Browser Windows page does not open");

        BrowserWindowPage browserWindow = new BrowserWindowPage();
        browserWindow.clickBrowserWindowElement();
        assertTrue(browserWindow.waitForPageToOpenAndCheckIfOpen(), "New tab doesn't open");

        browserWindow.clickNewTabElement();
        browserWindow.closeNewTab();
        assertTrue(browserWindow.waitForPageToOpenAndCheckIfOpen(), "The Browser Windows page does not open");

        browserWindow.clickElementsList();
        browserWindow.clickLinkElement();
        LinksPage linksPage = new LinksPage();
        assertTrue(linksPage.waitForPageToOpenAndCheckIfOpen(), "New page with Links doesn't open");

        String mainHandle = driver.getWindowHandle();
        linksPage.clickSimpleLink();
        linksPage.switchToNewTab();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        driver.switchTo().window(mainHandle);
        assertTrue(linksPage.waitForPageToOpenAndCheckIfOpen(), "Page with links form doesn't open");
    }
}
