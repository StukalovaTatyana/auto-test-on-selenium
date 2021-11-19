package com.a1qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MarketPage {
    private WebDriver driver;
    @FindBy(xpath = "//div[@class='market_search_advanced_button']")
    private WebElement advancedOptions;
    @FindBy(xpath = "//div[@id=\"app_option_0_selected\"]")
    private WebElement listGames;
    @FindBy(xpath = "//div[@id=\"app_option_570\"]")
    private WebElement dota;
    @FindBy(xpath = "//select[@name='category_570_Hero[]']")
//    @FindBy(xpath = "//input[@id='tag_570_Rarity_Rarity_Immortal']")
    private WebElement heroList;
    @FindBy(xpath = "//option[@value='tag_npc_dota_hero_life_stealer']")
    private WebElement hero;
    @FindBy(xpath = "//input[@id='tag_570_Rarity_Rarity_Immortal']")
    private WebElement immortal;
    @FindBy(xpath = "//input[@id='advancedSearchBox']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='btn_medium btn_green_white_innerfade']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@class='market_searchedForTerm']")
    private List<WebElement> filters;
    @FindBy(xpath = "//div[@id='searchResultsRows']//a//div[@class='market_listing_row market_recent_listing_row market_listing_searchresult']//div[@class='market_listing_item_name_block']")
    private List<WebElement> searchResultList;

    public MarketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAdvancedOptionsBtn() {
        advancedOptions.click();
    }

    public void clickListGames() {
        listGames.click();
    }

    public void clickDota() {
        dota.click();
    }

    public void clickHeroList() {
        heroList.click();
    }

    public void clickHero() {
        hero.click();
    }

    public void clickImmortal() {
        immortal.click();
    }

    public void sendGolden() {
        searchField.sendKeys("golden");
    }

    public void clickSearchBtn() {
        searchButton.click();
    }

    public List<String> getFiltersText() {
        return filters.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getSearchedItemNames() {
        return searchResultList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void removeGoldenFilter() {
        removeFilter("\"golden\"");
    }

    public void removeDotaFilter() {
        removeFilter("Dota 2");
    }

    private void removeFilter(String filterName) {
        Optional<WebElement> filter = filters.stream().filter(webElement -> webElement.getText().equals(filterName)).findFirst();
        filter.orElseThrow().click();
    }

    public int getFilterSize() {
        return filters.size();
    }

    public int getItemCount() {
        return searchResultList.size();
    }

    public void clickOnFirstItem() {
        searchResultList.stream().findFirst().orElseThrow().click();
    }

    public String getFirstItemName() {
        return searchResultList.stream().findFirst().orElseThrow().getText();
    }
}
