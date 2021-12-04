package com.a1qa.pages;

import com.a1qa.DriverManager;
import com.a1qa.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MarketPage {
    private final WebDriver driver;
    private final By advancedOptions;
    private final By listGames;
    private final By game;
    private final By heroList;
    private final By hero;
    private final By immortal;
    private final By searchField;
    private final By searchButton;
    private final By filters;
    private final By searchResultList;
    private final int DEFAULT_TIMEOUT = Configuration.getDefaultTimeout();
    private final int DEFAULT_MIDDLE_TIMEOUT = Configuration.getDefaultMiddleTimeout();

    public MarketPage() {
        this.driver = DriverManager.getInstance().getDriver();
        advancedOptions = By.xpath("//div[@class='market_search_advanced_button']");
        listGames = By.xpath("//div[@id=\"app_option_0_selected\"]");
        game = By.xpath("//div[@id=\"app_option_570\"]");
        heroList = By.xpath("//select[@name='category_570_Hero[]']");
        hero = By.xpath("//option[@value='tag_npc_dota_hero_life_stealer']");
        immortal = By.xpath("//input[@id='tag_570_Rarity_Rarity_Immortal']");
        searchField = By.xpath("//input[@id='advancedSearchBox']");
        searchButton = By.xpath("//div[@class='btn_medium btn_green_white_innerfade']");
        filters = By.xpath("//a[@class='market_searchedForTerm']");
        searchResultList = By.xpath("//div[@id='searchResultsRows']//a//div[@class='market_listing_row market_recent_listing_row market_listing_searchresult']//div[@class='market_listing_item_name_block']");
    }

    public void clickAdvancedOptionsBtn() {
        driver.findElement(advancedOptions).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@class = 'newmodal']")));
    }

    public void clickListGames() {
        driver.findElement(listGames).click();
    }

    public void clickGame() {
        driver.findElement(game).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(heroList));
    }

    public void clickHeroList() {
        driver.findElement(heroList).click();
    }

    public void clickHero() {
        driver.findElement(hero).click();
    }

    public void clickRarity() {
        driver.findElement(immortal).click();
    }

    public void sendGolden() {
        driver.findElement(searchField).sendKeys("golden");
    }

    public void clickSearchBtn() {
        driver.findElement(searchButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.withTimeout(Duration.ofSeconds(DEFAULT_MIDDLE_TIMEOUT));
    }

    public List<String> getFiltersText() {
        return driver.findElements(filters).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getSearchedItemNames() {
        return driver.findElements(searchResultList).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void removeGoldenFilter() {
        removeFilter("\"golden\"");
    }

    public void removeDotaFilter() {
        removeFilter("Dota 2");
    }

    private void removeFilter(String filterName) {
        Optional<WebElement> filter = driver.findElements(filters).stream().filter(webElement -> webElement.getText().equals(filterName)).findFirst();
        filter.orElseThrow().click();
    }

    public int getFilterSize() {
        return driver.findElements(filters).size();
    }

    public int getItemCount() {
        return driver.findElements(searchResultList).size();
    }

    public void clickOnFirstItem() {
        driver.findElements(searchResultList).stream().findFirst().orElseThrow().click();
    }

    public String getFirstItemName() {
        return driver.findElements(searchResultList).stream().findFirst().orElseThrow().getText();
    }
}
