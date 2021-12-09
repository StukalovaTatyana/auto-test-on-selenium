package com.a1qa.pages;

import com.a1qa.config.Configuration;
import com.a1qa.utils.DriverManager;
import com.a1qa.utils.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseForm {

    private final By uniqElement;
    private final String name;

    public BaseForm(By locator, String name) {
        this.uniqElement = locator;
        this.name = name;
    }

    public boolean isPageOpened() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(Configuration.getDefaultLongTimeout()));
            wait.until(ExpectedConditions.visibilityOfElementLocated(uniqElement));
            LoggerManager.getLogger().info(name + " is open");
            return true;
        } catch (Exception e) {
            LoggerManager.getLogger().info(name + " does not open");
            return false;
        }
    }

}
