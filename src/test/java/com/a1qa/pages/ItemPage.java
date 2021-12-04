package com.a1qa.pages;

import com.a1qa.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    private final WebDriver driver;
    private final By itemName;
    private final By heroName;
    private final By rarity;

    public ItemPage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        itemName = By.xpath("//h1[@id='largeiteminfo_item_name']");
        heroName = By.xpath("//div[@id='largeiteminfo_item_descriptors']//div[1]");
        rarity = By.xpath("//div[@id='largeiteminfo_item_type']");
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getHeroName() {
        return driver.findElement(heroName).getText();
    }

    public String getRarity() {
        return driver.findElement(rarity).getText();
    }
}
