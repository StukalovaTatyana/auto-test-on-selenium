package com.a1qa.pages;

import com.a1qa.DriverManager;
import com.a1qa.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage {
    private final WebDriver driver;
    private final By online;
    private final By playing;
    private final By store;
    private final int DEFAULT_TIMEOUT = Configuration.getDefaultTimeout();

    public AboutPage() {
        this.driver = DriverManager.getInstance().getDriver();
        online = By.xpath("//div[@class='online_stat'][1]");
        playing = By.xpath("//div[@class='online_stat'][2]");
        store = By.xpath("//div[@class='supernav_container']//a[@class='menuitem supernav'][1]");
    }

    public Long getCountOnline() {
        return getCount(driver.findElement(online));
    }

    public Long getCountPlaying() {
        return getCount(driver.findElement(playing));
    }

    private Long getCount(WebElement webElement) {
        String getText = webElement.getText();
        String countStr = getText.split("\n")[1].replace(",", "");
        return Long.parseLong(countStr);
    }

    public void clickStoreBtn() {
        driver.findElement(store).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
    }
}
