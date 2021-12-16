package com.a1qa;

import com.a1qa.pages.FramesPage;
import com.a1qa.pages.IframePage;
import com.a1qa.pages.MainPage;
import com.a1qa.utils.DriverManager;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IFrameTest extends BaseTest {
    @Test
    public void iframeTest() {
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        mainPage.clickAlertCard();
        IframePage iframePage = new IframePage();
        assertTrue(iframePage.waitForPageToOpenAndCheckIfOpen(), "The page with Nested Frames does not open");

        iframePage.clickIframeListElement();
        String textFromParentFrame = iframePage.getTextFromParentFrame();
        String textFromChildrenFrame = iframePage.getTextFromChildrenFrame();
        assertEquals(textFromParentFrame, "Parent frame", "Parent frame not contains in page");
        assertEquals(textFromChildrenFrame, "Child Iframe", "Child Iframe not contains in page");

        iframePage.clickFramesListElement();
        FramesPage framesPage = new FramesPage();
        assertTrue(framesPage.waitForPageToOpenAndCheckIfOpen(), "The frames page does not open");
        assertEquals(framesPage.getTextFromTopFrame(), framesPage.getTextFromBotFrame(), "The text of the upper frame does not match the text of the lower frame");
    }
}
