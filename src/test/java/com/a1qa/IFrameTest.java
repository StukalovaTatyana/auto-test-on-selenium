package com.a1qa;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IFrameTest extends BaseTest {
    @Test
    public void iframeTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened(), "The main page does not open");

        mainPage.clickAlertCard();
        assertTrue(iframePage.isPageOpened(), "The page with Nested Frames does not open");

        iframePage.clickIframeListElement();
        String textFromParentFrame = iframePage.getTextFromParentFrame();
        String textFromChildrenFrame = iframePage.getTextFromChildrenFrame();
        assertEquals(textFromParentFrame, "Parent frame", "Parent frame not contains in page");
        assertEquals(textFromChildrenFrame, "Child Iframe", "Child Iframe not contains in page");

        iframePage.clickFramesListElement();
        assertTrue(framesPage.isPageOpened(), "The frames page does not open");
        assertEquals(framesPage.getTextFromTopFrame(), framesPage.getTextFromBotFrame(), "The text of the upper frame does not match the text of the lower frame");
    }
}
