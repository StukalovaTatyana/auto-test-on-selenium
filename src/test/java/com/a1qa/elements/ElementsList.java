package com.a1qa.elements;

import com.a1qa.utils.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsList {
    final static Logger LOGGER = Logger.getLogger(IFrameElement.class.toString());

    private final By locator;
    private final String name;

    public ElementsList(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public List<WebElement> findElements() {
        LOGGER.info("try to find list of elements: " + name);
        return DriverManager.getInstance().findElements(locator);
    }
}
