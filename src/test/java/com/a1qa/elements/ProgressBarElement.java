package com.a1qa.elements;

import org.openqa.selenium.By;

public class ProgressBarElement extends BaseElement{
    public ProgressBarElement(By locator, String name) {
        super(locator, name);
    }

    public String getAreaValueNow(){
        return findElement().getAttribute("aria-valuenow");
    }

}
