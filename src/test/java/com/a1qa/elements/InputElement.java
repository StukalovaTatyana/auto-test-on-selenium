package com.a1qa.elements;

import com.a1qa.utils.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InputElement extends BaseElement {
    public InputElement(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        LoggerManager.getLogger().info("set text: " + text + " in element: " + name);
        findElement().sendKeys(text);
    }

    public String getValue() {
        return findElement().getAttribute("value");
    }

    public void sendKeys(Keys key) {
        findElement().sendKeys(key);
    }
}
