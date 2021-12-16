package com.a1qa.pages;

import com.a1qa.elements.ButtonElement;
import com.a1qa.elements.ListItemElement;
import com.a1qa.elements.TextElement;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends BaseForm {
    private final ListItemElement alertElement = new ListItemElement(
            By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-1']"),
            "alertsElement");
    private final TextElement alertForm = new TextElement(
            By.xpath("//div[@id='javascriptAlertsWrapper']"),
            "alertForm");
    private final ButtonElement alertButton = new ButtonElement(
            By.xpath("//button[@id='alertButton']"), "alertButton");
    private final ButtonElement confirmButton = new ButtonElement(
            By.xpath("//button[@id='confirmButton']"), "alertButtonWithDelay");
    private final TextElement confirmResult = new TextElement(
            By.xpath("//span[@id='confirmResult']"), "confirmResult");
    private final ButtonElement promptButton = new ButtonElement(
            By.xpath("//button[@id='promtButton']"), "promptButton");
    private final TextElement promptResult = new TextElement(
            By.xpath("//span[@id='promptResult']"), "promptResult");

    public AlertPage() {
        super(new TextElement(By.xpath("//section[@id='botton-text-10']"), "alertPageUniqElement"),
                "alertPage");
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
            return DriverManager.getInstance().switchTo().alert();
        } catch (NoAlertPresentException e) {
            return null;
        }
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    public Alert waitForAlert(int duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance(), Duration.ofSeconds(duration));
        return wait.until(driver -> driver.switchTo().alert());
    }

    public String getConfirmResult() {
        return confirmResult.getText();
    }

    public void clickPromptButton() {
        promptButton.click();
    }

    public String getPromptResult() {
        return promptResult.getText();
    }
}
