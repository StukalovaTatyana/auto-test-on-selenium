package com.a1qa.pages;

import com.a1qa.DriverManager;
import com.a1qa.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By about;
    private final By community;
    private final By communitySubmenu;
    private final By market;
    private final int DEFAULT_TIMEOUT = Configuration.getDefaultTimeout();

    public MainPage() {
        this.driver = DriverManager.getInstance().getDriver();
        market = By.xpath("//div[@class='supernav_content']//div[@data-submenuid='community']//a[4]");
        communitySubmenu = By.xpath("//div[@class='supernav_content']");
        about = By.xpath("//div[@id='global_header']//a[@class='menuitem'][1]");
        community = By.xpath("//div[@class='supernav_container']//a[@class='menuitem supernav'][2]");
    }

    public void clickAboutBtn() {
        driver.findElement(about).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
    }

    public void moveMouseToCommunity() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(community)).build().perform();
    }

    public double getCommunitySubmenuOpacity() {
        WebElement element = driver.findElement(communitySubmenu);
        String opacity = element.getCssValue("opacity");
        return Double.parseDouble(opacity);
    }

    public void clickCommunitySubmenuMarket() {
        driver.findElement(market).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BG_top")));
    }

    public void openMainPage() {
        driver.get(Configuration.getUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
    }
}
