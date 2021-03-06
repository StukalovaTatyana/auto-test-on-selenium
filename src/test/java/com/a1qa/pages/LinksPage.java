package com.a1qa.pages;

import com.a1qa.framework.elements.impl.ButtonElement;
import com.a1qa.framework.elements.impl.TextElement;
import com.a1qa.framework.form.BaseForm;
import com.a1qa.framework.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class LinksPage extends BaseForm {
    private final ButtonElement simpleLink = new ButtonElement(
            By.xpath("//a[@id='simpleLink']"), "simpleLink");

    public LinksPage() {
        super(new TextElement(By.xpath("//section[@id='botton-text-10']"), "linksPageUniqElement"), "linksPage");
    }

    public void clickSimpleLink() {
        simpleLink.click();
    }

    public void switchToNewTab() {
        WebDriver driver = DriverManager.getInstance();
        String mainWindow = driver.getWindowHandle();
        Set<String> setWindows = driver.getWindowHandles();
        Iterator<String> iterator = setWindows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!childWindow.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }


}
