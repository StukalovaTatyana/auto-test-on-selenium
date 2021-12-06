package com.a1qa.elements;

import com.a1qa.config.Configuration;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseElement {
    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public WebElement findElement() {
        try {
            return DriverManager.getInstance().getDriver().findElement(locator);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void click() {
        System.out.println(name + " is click");
        findElement().click();
    }

    public void waitForIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(
                DriverManager.getInstance().getDriver(),
                Duration.ofSeconds(Configuration.getDefaultLongTimeout())
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void focus() {
        Actions actions = new Actions(DriverManager.getInstance().getDriver());
        actions.moveToElement(findElement()).build().perform();
    }

}
