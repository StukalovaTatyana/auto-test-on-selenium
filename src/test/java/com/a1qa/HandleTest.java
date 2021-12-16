package com.a1qa;

import com.a1qa.elements.IFrameElement;
import com.a1qa.pages.AlertPage;
import com.a1qa.pages.BrowserWindowPage;
import com.a1qa.pages.LinksPage;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HandleTest extends BaseTest {
    final static Logger LOGGER = Logger.getLogger(IFrameElement.class.toString());

    @Test
    public void handleTest() {
        LOGGER.info("Opening main page");
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        LOGGER.info("Try to click on the 'Alerts, Frame & Windows'");
        mainPage.clickAlertCard();
        AlertPage alertPage = new AlertPage();
        assertTrue(alertPage.waitForPageToOpenAndCheckIfOpen(), "The Browser Windows page does not open");

        LOGGER.info("Try to click on the 'New Tab'");
        BrowserWindowPage browserWindow = new BrowserWindowPage();
        browserWindow.clickBrowserWindowElement();
        assertTrue(browserWindow.waitForPageToOpenAndCheckIfOpen(), "New tab doesn't open");

        LOGGER.info("Close the tab");
        browserWindow.clickNewTabElement();
        browserWindow.closeNewTab();
        assertTrue(browserWindow.waitForPageToOpenAndCheckIfOpen(), "The Browser Windows page does not open");

        LOGGER.info("Select In left menu 'Elements → Links'");
        browserWindow.clickElementsList();
        browserWindow.clickLinkElement();
        LinksPage linksPage = new LinksPage();
        assertTrue(linksPage.waitForPageToOpenAndCheckIfOpen(), "New page with Links doesn't open");

        LOGGER.info("Go to the Home link");
        String mainHandle = driver.getWindowHandle();
        linksPage.clickSimpleLink();
        linksPage.switchToNewTab();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        LOGGER.info("Switch to the previous tab");
        driver.switchTo().window(mainHandle);
        assertTrue(linksPage.waitForPageToOpenAndCheckIfOpen(), "Page with links form doesn't open");
    }
}
