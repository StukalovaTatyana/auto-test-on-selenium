package com.a1qa.elements;

import com.a1qa.config.Configuration;
import com.a1qa.utils.DriverManager;
import com.a1qa.utils.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseElement {
    protected final By locator;
    protected final String name;
    private final String FOCUS_SCRIPT = "arguments[0].scrollIntoView(true);";

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public WebElement findElement() {
        LoggerManager.getLogger().info("try to find element: " + name);
        return DriverManager.getInstance().findElement(locator);
    }

    public void click() {
        LoggerManager.getLogger().info(name + " is click");
        findElement().click();
    }

    public void waitForIsDisplayed() {
        LoggerManager.getLogger().info("wait for is displayed element: " + name);
        WebDriverWait wait = new WebDriverWait(
                DriverManager.getInstance(),
                Duration.ofSeconds(Configuration.getDefaultLongTimeout())
        );
        wait.pollingEvery(Duration.ofMillis(Configuration.getDefaultPolingRateMilli()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void focus() {
        LoggerManager.getLogger().info("scroll and focus on element: " + name);
        WebDriver driver = DriverManager.getInstance();
        //scroll before move mouse
        ((JavascriptExecutor) driver).executeScript(FOCUS_SCRIPT, findElement());
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement()).perform();
    }

    public String getText() {
        LoggerManager.getLogger().info("get text from element: " + name);
        return findElement().getText();
    }
}
