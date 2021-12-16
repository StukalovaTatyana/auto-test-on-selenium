package com.a1qa.pages;

import com.a1qa.elements.ButtonElement;
import com.a1qa.elements.ListItemElement;
import com.a1qa.elements.TextElement;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowPage extends BaseForm {
    private final TextElement browserWindowElement = new TextElement(
            By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-0']"),
            "browserWindowElement");
    private final ButtonElement newTabElement = new ButtonElement(
            By.xpath("//button[@id='tabButton']"), "newTabElement");
    private final ButtonElement elementsList = new ButtonElement(
            By.xpath("//div[contains(text(),'Elements')]"), "elementsList");
    private final ListItemElement linkElement = new ListItemElement(
            By.xpath("//div[@class ='element-list collapse show']//ul//li[@id='item-5']"),
            "linkElement");

    public BrowserWindowPage() {
        super(By.xpath("//section[@id='botton-text-10']"), "elementsPage");
    }

    public void clickBrowserWindowElement() {
        browserWindowElement.click();
    }

    public void clickNewTabElement() {
        newTabElement.click();
    }

    public void clickElementsList() {
        elementsList.click();
    }

    public void clickLinkElement() {
        linkElement.waitForIsDisplayed();
        linkElement.focus();
        linkElement.click();
    }

    public void closeNewTab() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        String mainWindow = driver.getWindowHandle();
        Set<String> setWindows = driver.getWindowHandles();
        Iterator<String> iterator = setWindows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!childWindow.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(childWindow);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

}
