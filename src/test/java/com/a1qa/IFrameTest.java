package com.a1qa;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IFrameTest extends BaseTest {
    @Test
    public void iframeTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened());

        mainPage.clickAlertCard();
        assertTrue(iframePage.isPageOpened());

        iframePage.clickIframeListElement();
        String textFromParentFrame = iframePage.getTextFromParentFrame();
        String textFromChildrenFrame = iframePage.getTextFromChildrenFrame();
        assertEquals(textFromParentFrame, "Parent frame");
        assertEquals(textFromChildrenFrame, "Child Iframe");

        iframePage.clickFramesListElement();
        assertTrue(framesPage.isPageOpened());
        assertEquals(framesPage.getTextFromTopFrame(), framesPage.getTextFromBotFrame());
    }
}
