package com.a1qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    @FindBy(xpath = "//div[@id='global_header']//a[@class='menuitem'][1]")
    private WebElement about;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAboutBtn() {
        about.click();
    }

}
