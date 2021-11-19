package com.a1qa;

import com.a1qa.config.Configuration;
import com.a1qa.pages.AboutPage;
import com.a1qa.pages.MainPage;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ChromeTest {
    private WebDriver driver;
    private MainPage mainPage;
    private AboutPage aboutPage;

    @BeforeClass
    public void setupClass() {

        driver = DriverManager.getInstance().getDriver();

        mainPage = new MainPage(driver);
        aboutPage = new AboutPage(driver);

        driver.manage().window().setSize(new Dimension(Configuration.getScreenWidth(),Configuration.getScreenHeight()));
    }

    @Test
    public void testCaseOne() {
        try {
            driver.get(Configuration.getUrl());
        } catch (Exception e){
            fail("Main page does not load", e);
        }

        try {
            mainPage.clickAboutBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
        } catch (Exception e){
            fail("About page does not load", e);
        }

        long countOnline = aboutPage.getCountOnline();
        long countPlaying = aboutPage.getCountPlaying();

        assertTrue(countOnline > countPlaying);

        try {
            aboutPage.clickStoreBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
        } catch (Exception e){
            fail("Store page does not load", e);
        }
    }

    @AfterClass
    private void closeBrowser(){
        driver.close();
    }
}
