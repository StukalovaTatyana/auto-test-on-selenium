package com.a1qa.pages;

import com.a1qa.elements.ButtonElement;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class LinksPage extends BaseForm{
    private final ButtonElement simpleLink;


    public LinksPage() {
        super(By.xpath("//section[@id='botton-text-10']"), "linksPage");
        simpleLink = new ButtonElement(
                By.xpath("//a[@id='simpleLink']"), "simpleLink");
    }

    public void clickSimpleLink(){
        simpleLink.click();
    }
    public void switchToNewTab(){
        WebDriver driver = DriverManager.getInstance().getDriver();
        String mainWindow = driver.getWindowHandle();
        Set<String> setWindows = driver.getWindowHandles();
        Iterator<String> iterator = setWindows.iterator();
        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if (!childWindow.equalsIgnoreCase(mainWindow)){
                driver.switchTo().window(childWindow);
            }
        }
    }


}
