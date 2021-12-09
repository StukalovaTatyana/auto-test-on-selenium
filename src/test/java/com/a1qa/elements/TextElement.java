package com.a1qa.elements;

import com.a1qa.utils.LoggerManager;
import org.openqa.selenium.By;

public class TextElement extends BaseElement {
    public TextElement(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        LoggerManager.getLogger().info("get text from element: " + name);
        return findElement().getText();
    }
}
