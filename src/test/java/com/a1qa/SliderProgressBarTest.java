package com.a1qa;

import com.a1qa.framework.test.BaseTest;
import com.a1qa.framework.utils.DriverManager;
import com.a1qa.framework.utils.Generator;
import com.a1qa.pages.MainPage;
import com.a1qa.pages.WidgetsPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SliderProgressBarTest extends BaseTest {
    final static Logger LOGGER = Logger.getLogger(SliderProgressBarTest.class.toString());
    private final int age = 26;
    private final int errorRate = 2;

    @Test
    public void SliderProgressBarTest() {
        LOGGER.info("Opening main page");
        MainPage mainPage = new MainPage();
        DriverManager.openMainPage();
        assertTrue(mainPage.waitForPageToOpenAndCheckIfOpen(), "The main page does not open");

        LOGGER.info("Try to click on the 'Alerts, Frame & Windows'");
        mainPage.clickWidgetsCard();
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.clickSliderListElement();
        assertTrue(widgetsPage.isSliderDisplayed(), "The slider page does not open");

        LOGGER.info("Set sliders to the correct randomly generated value");
        int randomValue = Generator.numberGenerate();
        widgetsPage.moveSlider(randomValue);
        assertEquals(randomValue, Integer.parseInt(widgetsPage.getSliderTextBoxValue()),
                "The value next to the slider does not match the randomly generated one");

        LOGGER.info("In the left menu, select Progress Bar");
        widgetsPage.clickProgressBarListElement();
        assertTrue(widgetsPage.isProgressBarDisplayed(), "The progress bar page does not open");

        LOGGER.info("Click on the Start button");
        widgetsPage.clickStartStopButton();
        widgetsPage.clickStopAge(age);
        assertTrue(Math.abs(age - Integer.parseInt(widgetsPage.getAreaValueNow())) <= errorRate,
                "The value on the loading strip corresponds to the age of the engineer (the error does not exceed 2%)");


    }
}
