package com.a1qa;

import com.a1qa.pages.MainPage;
import com.a1qa.pages.WidgetsPage;
import com.a1qa.utils.DriverManager;
import com.a1qa.utils.Generator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SliderProgressBarTest extends BaseTest {
    private final int age = 26;
    private final int errorRate = 2;

    @Test
    public void SliderProgressBarTest() {
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        mainPage.clickWidgetsCard();
        WidgetsPage widgetsPage = new WidgetsPage();
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
