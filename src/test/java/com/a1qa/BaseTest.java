package com.a1qa;

import com.a1qa.pages.*;
import com.a1qa.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected AlertPage alertPage;
    protected IframePage iframePage;
    protected FramesPage framesPage;
    protected ElementsPage elementsPage;
    protected BrowserWindowPage browserWindow;
    protected LinksPage linksPage;

    @BeforeMethod
    protected void setupClass() {
        driver = DriverManager.getInstance().openBrowser();
        mainPage = new MainPage();
        alertPage = new AlertPage();
        iframePage = new IframePage();
        framesPage = new FramesPage();
        elementsPage = new ElementsPage();
        browserWindow = new BrowserWindowPage();
        linksPage = new LinksPage();
    }

    //@AfterMethod
    protected void closeBrowser() {
        driver.quit();
    }
}
