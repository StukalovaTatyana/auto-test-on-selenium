package com.a1qa;

import com.a1qa.framework.test.BaseTest;
import com.a1qa.framework.utils.DriverManager;
import com.a1qa.pages.FramesPage;
import com.a1qa.pages.IframePage;
import com.a1qa.pages.MainPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IFrameTest extends BaseTest {
    final static Logger LOGGER = Logger.getLogger(IFrameTest.class.toString());

    @Test
    public void iframeTest() {
        LOGGER.info("Opening main page");
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        LOGGER.info("Try to click on the 'Alerts, Frame & Windows'");
        mainPage.clickAlertCard();
        IframePage iframePage = new IframePage();
        assertTrue(iframePage.waitForPageToOpenAndCheckIfOpen(), "The page with Nested Frames does not open");

        LOGGER.info("On the page that opens, click Nested Frames in the left menu");
        iframePage.clickIframeListElement();
        String textFromParentFrame = iframePage.getTextFromParentFrame();
        String textFromChildrenFrame = iframePage.getTextFromChildrenFrame();
        assertEquals(textFromParentFrame, "Parent frame", "Parent frame not contains in page");
        assertEquals(textFromChildrenFrame, "Child Iframe", "Child Iframe not contains in page");

        LOGGER.info("In the left menu, select Frames");
        iframePage.clickFramesListElement();
        FramesPage framesPage = new FramesPage();
        assertTrue(framesPage.waitForPageToOpenAndCheckIfOpen(), "The frames page does not open");
        assertEquals(framesPage.getTextFromTopFrame(), framesPage.getTextFromBotFrame(), "The text of the upper frame does not match the text of the lower frame");
    }
}
