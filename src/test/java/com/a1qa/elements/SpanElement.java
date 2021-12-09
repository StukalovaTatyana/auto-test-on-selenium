package com.a1qa.elements;

import org.openqa.selenium.By;

public class SpanElement extends BaseElement{
    public SpanElement(By locator, String name) {
        super(locator, name);
    }
    public String getText(){
        return findElement().getText();
    }
}
