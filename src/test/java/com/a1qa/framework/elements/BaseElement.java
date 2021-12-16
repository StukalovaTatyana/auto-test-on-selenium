package com.a1qa.framework.elements;

import com.a1qa.config.Configuration;
import com.a1qa.framework.utils.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseElement {
    final static Logger LOGGER = Logger.getLogger(BaseElement.class.toString());

    protected final By locator;
    protected final String name;
    private final String FOCUS_SCRIPT = "arguments[0].scrollIntoView(true);";

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public WebElement findElement() {
        LOGGER.info("try to find element: " + name);
        return DriverManager.getInstance().findElement(locator);
    }

    public void click() {
        LOGGER.info(name + " is click");
        findElement().click();
    }

    public void waitForIsDisplayed() {
        LOGGER.info("wait for is displayed element: " + name);
        WebDriverWait wait = new WebDriverWait(
                DriverManager.getInstance(),
                Duration.ofSeconds(Configuration.getDefaultLongTimeout())
        );
        wait.pollingEvery(Duration.ofMillis(Configuration.getDefaultPolingRateMilli()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void focus() {
        LOGGER.info("scroll and focus on element: " + name);
        WebDriver driver = DriverManager.getInstance();
        //scroll before move mouse
        ((JavascriptExecutor) driver).executeScript(FOCUS_SCRIPT, findElement());
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement()).perform();
    }

    public String getText() {
        LOGGER.info("get text from element: " + name);
        return findElement().getText();
    }
}
