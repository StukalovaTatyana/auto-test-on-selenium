package com.a1qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
    private WebDriver driver;
    @FindBy(xpath = "//div[@class='online_stat'][1]")
    private WebElement online;
    @FindBy(xpath = "//div[@class='online_stat'][2]")
    private WebElement playing;
    @FindBy(xpath = "//div[@class='supernav_container']//a[@class='menuitem supernav'][1]")
    private WebElement store;

    public AboutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Long getCountOnline(){
        return getCount(online);
    }
    public Long getCountPlaying(){
        return getCount(playing);
    }
    private Long getCount(WebElement webElement){
        String getText = webElement.getText();
        String countStr = getText.split("\n")[1].replace(",", "");
        return Long.parseLong(countStr);
    }
    public void clickStoreBtn(){
        store.click();
    }
}
