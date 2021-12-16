package com.a1qa.pages;

import com.a1qa.elements.BaseElement;
import com.a1qa.elements.IFrameElement;
import org.apache.log4j.Logger;

public abstract class BaseForm {
    final static Logger LOGGER = Logger.getLogger(IFrameElement.class.toString());

    private final BaseElement uniqElement;
    private final String name;

    public BaseForm(BaseElement locator, String name) {
        this.uniqElement = locator;
        this.name = name;
    }

    public boolean waitForPageToOpenAndCheckIfOpen() {
        try {
            uniqElement.waitForIsDisplayed();
            LOGGER.info(name + " is open");
            return true;
        } catch (Exception e) {
            LOGGER.info(name + " does not open");
            return false;
        }
    }

}
