package com.a1qa.pages;

import com.a1qa.DriverManager;
import com.a1qa.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    @FindBy(xpath = "//div[@id='global_header']//a[@class='menuitem'][1]")
    private WebElement about;
    @FindBy(xpath = "//div[@class='supernav_container']//a[@class='menuitem supernav'][2]")
    private WebElement community;
    @FindBy(xpath = "//div[@class='supernav_content']")
    private WebElement communitySubmenu;
    @FindBy(xpath = "//div[@class='supernav_content']//div[@data-submenuid='community']//a[4]")
    private WebElement market;
    private final int DEFAULT_TIMEOUT = Configuration.getDefaultTimeout();

    public MainPage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickAboutBtn() {
        about.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
    }

    public void moveMouseToCommunity() {
        Actions actions = new Actions(driver);
        actions.moveToElement(community).build().perform();
    }

    public double getCommunitySubmenuOpacity() {
        String opacity = communitySubmenu.getCssValue("opacity");
        return Double.parseDouble(opacity);
    }

    public void clickCommunitySubmenuMarket() {
        market.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BG_top")));
    }

    public void openMainPage() {
        driver.get(Configuration.getUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
    }
}
