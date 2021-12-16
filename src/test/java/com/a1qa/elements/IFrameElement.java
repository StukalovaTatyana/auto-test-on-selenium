package com.a1qa.elements;

import com.a1qa.utils.DriverManager;
import com.a1qa.utils.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFrameElement {
    protected final By locator;
    protected final String name;

    public IFrameElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void switchToFrameDriver() {
        LoggerManager.getLogger().info("driver switched to " + name);
        DriverManager.getInstance().switchTo().frame(findElement());
    }

    public WebElement findElement() {
        LoggerManager.getLogger().info("try to find frame element: " + name);
        return DriverManager.getInstance().findElement(locator);
    }

    public void switchToMainDriver() {
        LoggerManager.getLogger().info("reset to main driver in " + name);
        DriverManager.getInstance().switchTo().defaultContent();
    }
}
