package com.a1qa;

import com.a1qa.pages.AboutPage;
import com.a1qa.pages.MainPage;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

public class ChromeTest {
    private WebDriver driver;
    private MainPage mainPage;
    private AboutPage aboutPage;

    @BeforeClass
    public void setupClass() {
        ChromeDriverManager.getInstance().setup();

        driver = DriverManager.getInstance().getDriver();

        mainPage = new MainPage(driver);
        aboutPage = new AboutPage(driver);

        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://store.steampowered.com");

        mainPage.clickAboutBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));

        long countOnline = aboutPage.getCountOnline();
        long countPlaying = aboutPage.getCountPlaying();

        assertTrue(countOnline > countPlaying);

        aboutPage.clickStoreBtn();
    }
}
