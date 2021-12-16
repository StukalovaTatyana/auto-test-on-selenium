package com.a1qa.framework.form;

import com.a1qa.framework.elements.BaseElement;
import org.apache.log4j.Logger;

public abstract class BaseForm {
    final static Logger LOGGER = Logger.getLogger(BaseForm.class.toString());

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
