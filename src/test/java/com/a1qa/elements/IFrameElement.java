package com.a1qa.elements;

import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFrameElement extends BaseElement {
    public IFrameElement(By locator, String name) {
        super(locator, name);
    }

    public WebDriver switchToFrameDriver() {
        return DriverManager.getInstance().getDriver().switchTo().frame(findElement());
    }

    public WebDriver switchToMainDriver() {
        return DriverManager.getInstance().getDriver().switchTo().defaultContent();
    }
}
