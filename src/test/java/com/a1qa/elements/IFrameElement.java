package com.a1qa.elements;

import com.a1qa.utils.DriverManager;
import com.a1qa.utils.LoggerManager;
import org.openqa.selenium.By;

public class IFrameElement extends BaseElement {
    public IFrameElement(By locator, String name) {
        super(locator, name);
    }

    public void switchToFrameDriver() {
        LoggerManager.getLogger().info("driver switched to " + name);
        DriverManager.getInstance().getDriver().switchTo().frame(findElement());
    }

    public void switchToMainDriver() {
        LoggerManager.getLogger().info("reset to main driver in " + name);
        DriverManager.getInstance().getDriver().switchTo().defaultContent();
    }
}
