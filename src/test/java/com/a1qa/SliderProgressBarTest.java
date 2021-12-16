package com.a1qa;

import com.a1qa.utils.Generator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SliderProgressBarTest extends BaseTest {
    private int age = 26;
    private int errorRate = 2;

    @Test
    public void SliderProgressBarTest() {
        mainPage.openMainPage();
        assertTrue(mainPage.isPageOpened(), "The main page does not open");

        mainPage.clickWidgetsCard();
        widgetsPage.clickSliderListElement();
        assertTrue(widgetsPage.isSliderDisplayed(), "The slider page does not open");

        int randomValue = Generator.numberGenerate();
        widgetsPage.moveSlider(randomValue);
        assertEquals(randomValue, Integer.parseInt(widgetsPage.getSliderTextBoxValue()),
                "The value next to the slider does not match the randomly generated one");

        widgetsPage.clickProgressBarListElement();
        assertTrue(widgetsPage.isProgressBarDisplayed(), "The progress bar page does not open");

        widgetsPage.clickStartStopButton();
        widgetsPage.clickStopAge(age);
        assertTrue(Math.abs(age - Integer.parseInt(widgetsPage.getAreaValueNow())) <= errorRate,
                "The value on the loading strip corresponds to the age of the engineer (the error does not exceed 2%)");


    }
}
