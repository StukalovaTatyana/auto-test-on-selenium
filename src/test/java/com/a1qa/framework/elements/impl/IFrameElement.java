package com.a1qa.framework.elements.impl;

import com.a1qa.framework.utils.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFrameElement {
    final static Logger LOGGER = Logger.getLogger(IFrameElement.class.toString());

    protected final By locator;
    protected final String name;

    public IFrameElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void switchToFrameDriver() {
        LOGGER.info("driver switched to " + name);
        DriverManager.getInstance().switchTo().frame(findElement());
    }

    public WebElement findElement() {
        LOGGER.info("try to find frame element: " + name);
        return DriverManager.getInstance().findElement(locator);
    }

    public void switchToMainDriver() {
        LOGGER.info("reset to main driver in " + name);
        DriverManager.getInstance().switchTo().defaultContent();
    }
}
