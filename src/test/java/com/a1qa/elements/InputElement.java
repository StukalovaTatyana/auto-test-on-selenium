package com.a1qa.elements;

import org.openqa.selenium.By;

public class InputElement extends BaseElement {
    public InputElement(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        findElement().sendKeys(text);
    }
}
