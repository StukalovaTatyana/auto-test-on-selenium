package com.a1qa.pages;

import com.a1qa.config.Configuration;
import com.a1qa.elements.DivElement;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private final DivElement alertCard;

    public MainPage() {
        super(By.xpath("//*[@id='app']"), "mainPage");
        alertCard = new DivElement(
                By.xpath("//div[@class='card-body']//h5[contains(text(),'Alerts')]//..//..//.."),
                "alertCard"
        );
    }

    public void openMainPage() {
        DriverManager.getInstance().getDriver().get(Configuration.getUrl());
    }

    public void clickAlertCard() {
        alertCard.click();
    }
}

