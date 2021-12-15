package com.a1qa.pages;

import com.a1qa.config.Configuration;
import com.a1qa.elements.*;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WidgetsPage extends BaseForm {
    private final ListItemElement sliderListItem;
    private final ListItemElement progressBarListItem;
    private final TextElement sliderForm;
    private final InputElement slider;
    private final InputElement sliderTextBox;
    private final TextElement progressBarForm;
    private final ButtonElement startStopButton;
    private final ProgressBarElement progressBarElement;

    public WidgetsPage() {
        super(By.xpath("//section[@id='botton-text-10']"), "widgetPage");
        sliderListItem = new ListItemElement(
                By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-3']"), "sliderPage"
        );
        progressBarListItem = new ListItemElement(
                By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-4']"), "progressBarList"
        );
        sliderForm = new TextElement(By.xpath("//div[@id='sliderContainer']"), "sliderForm");
        progressBarForm = new TextElement(By.xpath("//div[@id='progressBarContainer']"), "progressBarForm");
        slider = new InputElement(By.xpath("//input[@class='range-slider range-slider--primary']"), "slider");
        sliderTextBox = new InputElement(By.xpath("//input[@id='sliderValue']"), "sliderTextBox");
        startStopButton = new ButtonElement(By.xpath("//button[@id='startStopButton']"), "startStopButton");
        progressBarElement = new ProgressBarElement(By.xpath("//div[@class='progress-bar bg-info']"), "progressBarElement");

    }

    public void clickSliderListElement() {
        sliderListItem.focus();
        sliderListItem.click();
    }

    public void clickProgressBarListElement() {
        progressBarListItem.focus();
        progressBarListItem.click();
    }

    public boolean isSliderDisplayed() {
        try {
            sliderForm.waitForIsDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void moveSlider(int number) {
        int value = Integer.parseInt(slider.getValue());
        int res = number - value;
        if (res > 0) {
            for (int i = 0; i < res; i++) {
                slider.sendKeys(Keys.RIGHT);
            }
        } else {
            for (int i = 0; i > res; i--) {
                slider.sendKeys(Keys.LEFT);
            }
        }
    }

    public String getSliderTextBoxValue() {
        return sliderTextBox.getValue();
    }

    public boolean isProgressBarDisplayed() {
        try {
            progressBarForm.waitForIsDisplayed();
            progressBarElement.focus();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickStartStopButton() {
        startStopButton.click();
    }

    public void clickStopAge(int age) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(Configuration.getDefaultLongTimeout()));
        wait.pollingEvery(Duration.ofMillis(50));
        Boolean until = wait.until(
                ExpectedConditions.attributeContains(progressBarElement.findElement(),
                        "aria-valuenow",
                        String.valueOf(age))
        );
        clickStartStopButton();
    }

    public String getAreaValueNow(){
        return progressBarElement.getAreaValueNow();
    }

}
