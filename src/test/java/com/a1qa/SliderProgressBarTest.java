package com.a1qa;

import com.a1qa.utils.Generator;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SliderProgressBarTest extends BaseTest {
    private int age = 26;
    private int errorRate = 2;

    @Test
    public void SliderProgressBarTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened());

        mainPage.clickWidgetsCard();
        widgetsPage.clickSliderListElement();
        assertTrue(widgetsPage.isSliderDisplayed());

        int randomValue = Generator.numberGenerate();
        widgetsPage.moveSlider(randomValue);
        assertEquals(randomValue, Integer.parseInt(widgetsPage.getSliderTextBoxValue()));

        widgetsPage.clickProgressBarListElement();
        assertTrue(widgetsPage.isProgressBarDisplayed());

        widgetsPage.clickStartStopButton();
        widgetsPage.clickStopAge(age);
        assertTrue(Math.abs(age - Integer.parseInt(widgetsPage.getAreaValueNow())) <= errorRate);


    }
}
