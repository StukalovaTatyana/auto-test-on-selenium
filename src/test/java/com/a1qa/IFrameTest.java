package com.a1qa;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class IFrameTest extends BaseTest{
    @Test
    public void ifameTest(){
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened());

        mainPage.clickAlertCard();
        assertTrue(iframePage.isPageOpened());

        iframePage.clickIframeButton();

    }
}
