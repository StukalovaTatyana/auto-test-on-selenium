package com.a1qa.pages;

import com.a1qa.config.Configuration;
import com.a1qa.elements.TextElement;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private final TextElement alertCard = new TextElement(
            By.xpath("//div[@class='card-body']//h5[contains(text(),'Alerts')]/../../.."),
            "alertCard");
    private final TextElement elementsCard = new TextElement(
            By.xpath("//div[@class='card-body']//h5[contains(text(),'Elements')]/../../.."),
            "elementsCard");
    private final TextElement widgets = new TextElement(
            By.xpath("//div[@class='card-body']//h5[contains(text(),'Widgets')]/../../.."),
            "widgets");

    public MainPage() {
        super(By.xpath("//*[@id='app']"), "mainPage");
    }

    public void openMainPage() {
        DriverManager.getInstance().getDriver().get(Configuration.getUrl());
    }

    public void clickAlertCard() {
        alertCard.click();
    }

    public void clickElementsCard() {
        elementsCard.click();
    }

    public void clickWidgetsCard() {
        widgets.click();
    }
}

