package com.a1qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    private WebDriver driver;
    @FindBy(xpath = "//h1[@id='largeiteminfo_item_name']")
    private WebElement itemName;
    @FindBy(xpath = "//div[@id='largeiteminfo_item_descriptors']//div[1]")
    private WebElement heroName;
    @FindBy(xpath = "//div[@id='largeiteminfo_game_name']")
    private WebElement game;
    @FindBy(xpath = "//div[@id='largeiteminfo_item_type']")
    private WebElement rarity;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getHeroName() {
        return heroName.getText();
    }

    public String getGame() {
        return game.getText();
    }

    public String getRarity() {
        return rarity.getText();
    }
}
