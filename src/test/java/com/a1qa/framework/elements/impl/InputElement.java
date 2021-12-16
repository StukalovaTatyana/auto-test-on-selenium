package com.a1qa.framework.elements.impl;

import com.a1qa.framework.elements.BaseElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InputElement extends BaseElement {
    final static Logger LOGGER = Logger.getLogger(InputElement.class.toString());

    public InputElement(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        LOGGER.info("set text: " + text + " in element: " + name);
        findElement().sendKeys(text);
    }

    public String getValue() {
        return findElement().getAttribute("value");
    }

    public void sendKeys(Keys key) {
        findElement().sendKeys(key);
    }
}
