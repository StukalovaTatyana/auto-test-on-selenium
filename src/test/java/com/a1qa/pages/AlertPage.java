package com.a1qa.pages;

import com.a1qa.elements.ButtonElement;
import com.a1qa.elements.DivElement;
import com.a1qa.elements.ListItemElement;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends BaseForm {
    private ListItemElement alertElement;
    private DivElement alertForm;
    private ButtonElement alertButton;
//    private ButtonElement alertButtonWithDelay;

    public AlertPage() {
        super(By.xpath("//section[@id='botton-text-10']"), "alertPage");
        alertElement = new ListItemElement(
                By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-1']"),
                "alertsElement");
        alertForm = new DivElement(
                By.xpath("//div[@id='javascriptAlertsWrapper']"),
                "alertForm");
        alertButton = new ButtonElement(
                By.xpath("//button[@id='alertButton']"), "alertButton");
//        alertButtonWithDelay = new ButtonElement(
//                By.xpath("//button[@id='timerAlertButton']"), "alertButtonWithDelay");
    }

    public void clickAlertListElement() {
        alertElement.click();
    }

    public boolean isAlertFormDisplayed() {
        try {
            alertForm.waitForIsDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAlertButton() {
        alertButton.click();
    }

    public Alert switchToAlert() {
        try {
            return DriverManager.getInstance().getDriver().switchTo().alert();
        } catch (NoAlertPresentException e) {
            return null;
        }
    }

//    public void clickAlertButtonWithDelay() {
//        alertButtonWithDelay.click();
//    }

    public Alert waitForAlert(int duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(duration));
        return wait.until(driver -> driver.switchTo().alert());
    }
}
