package com.a1qa.pages;

import com.a1qa.DriverManager;
import com.a1qa.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage {
    private final WebDriver driver;
    @FindBy(xpath = "//div[@class='online_stat'][1]")
    private WebElement online;
    @FindBy(xpath = "//div[@class='online_stat'][2]")
    private WebElement playing;
    @FindBy(xpath = "//div[@class='supernav_container']//a[@class='menuitem supernav'][1]")
    private WebElement store;
    private final int DEFAULT_TIMEOUT = Configuration.getDefaultTimeout();

    public AboutPage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public Long getCountOnline() {
        return getCount(online);
    }

    public Long getCountPlaying() {
        return getCount(playing);
    }

    private Long getCount(WebElement webElement) {
        String getText = webElement.getText();
        String countStr = getText.split("\n")[1].replace(",", "");
        return Long.parseLong(countStr);
    }

    public void clickStoreBtn() {
        store.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
    }
}
