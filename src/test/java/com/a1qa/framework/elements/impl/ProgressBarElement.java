package com.a1qa.framework.elements.impl;

import com.a1qa.framework.elements.BaseElement;
import org.openqa.selenium.By;

public class ProgressBarElement extends BaseElement {
    public ProgressBarElement(By locator, String name) {
        super(locator, name);
    }

    public String getAreaValueNow() {
        return findElement().getAttribute("aria-valuenow");
    }

}
