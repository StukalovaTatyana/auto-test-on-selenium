package com.a1qa.pages;

import com.a1qa.elements.BaseElement;
import com.a1qa.utils.LoggerManager;

public abstract class BaseForm {

    private final BaseElement uniqElement;
    private final String name;

    public BaseForm(BaseElement locator, String name) {
        this.uniqElement = locator;
        this.name = name;
    }

    public boolean waitForPageToOpenAndCheckIfOpen() {
        try {
            uniqElement.waitForIsDisplayed();
            LoggerManager.getLogger().info(name + " is open");
            return true;
        } catch (Exception e) {
            LoggerManager.getLogger().info(name + " does not open");
            return false;
        }
    }

}
