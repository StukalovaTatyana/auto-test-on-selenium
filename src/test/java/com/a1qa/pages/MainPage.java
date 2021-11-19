package com.a1qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    @FindBy(xpath = "//div[@id='global_header']//a[@class='menuitem'][1]")
    private WebElement about;
    @FindBy(xpath = "//div[@class='supernav_container']//a[@class='menuitem supernav'][2]")
    private WebElement community;
    @FindBy(xpath = "//div[@class='supernav_content']")
    private WebElement communitySubmenu;
    @FindBy(xpath = "//div[@class='supernav_content']//div[@data-submenuid='community']//a[4]")
    private WebElement market;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAboutBtn() {
        about.click();
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
    }
}
