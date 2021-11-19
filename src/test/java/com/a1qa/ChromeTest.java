package com.a1qa;

import com.a1qa.config.Configuration;
import com.a1qa.pages.AboutPage;
import com.a1qa.pages.ItemPage;
import com.a1qa.pages.MainPage;
import com.a1qa.pages.MarketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class ChromeTest {
    private WebDriver driver;
    private MainPage mainPage;
    private AboutPage aboutPage;
    private MarketPage marketPage;
    private ItemPage itemPage;

    @BeforeClass
    public void setupClass() {
        driver = DriverManager.getInstance().getDriver();

        mainPage = new MainPage(driver);
        aboutPage = new AboutPage(driver);
        marketPage = new MarketPage(driver);
        itemPage = new ItemPage(driver);

        driver
                .manage()
                .window()
                .setSize(new Dimension(
                        Configuration.getScreenWidth(),
                        Configuration.getScreenHeight()
                ));
    }

    @Test
    public void testCaseOne() {
        try {
            driver.get(Configuration.getUrl());
        } catch (Exception e) {
            fail("Main page does not load", e);
        }

        try {
            mainPage.clickAboutBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
        } catch (Exception e) {
            fail("About page does not load", e);
        }

        long countOnline = aboutPage.getCountOnline();
        long countPlaying = aboutPage.getCountPlaying();

        assertTrue(countOnline > countPlaying);

        try {
            aboutPage.clickStoreBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global_header")));
        } catch (Exception e) {
            fail("Store page does not load", e);
        }
    }

    @Test
    public void testCaseThree() {
        try {
            driver.get(Configuration.getUrl());
        } catch (Exception e) {
            fail("Main page does not load", e);
        }
        mainPage.moveMouseToCommunity();
        double opacity = mainPage.getCommunitySubmenuOpacity();
        assertTrue(opacity > 0.5);
        try {
            mainPage.clickCommunitySubmenuMarket();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BG_top")));
        } catch (Exception e) {
            fail("Market page does not load", e);
        }
        try {
            marketPage.clickAdvancedOptionsBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@class = 'newmodal']")));
        } catch (Exception e) {
            fail("Search form does not load", e);
        }
        marketPage.clickListGames();

        try {
            marketPage.clickDota();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='category_570_Hero[]']")));
        } catch (Exception e) {
            fail("Hero does not load", e);
        }

        marketPage.clickHeroList();

        marketPage.clickHero();

        marketPage.clickImmortal();

        marketPage.sendGolden();

        marketPage.clickSearchBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(2));

        List<String> filtersText = marketPage.getFiltersText();
        boolean anyMatch = filtersText.stream()
                .anyMatch(s -> s.equals("Dota 2") || s.equals("Lifestealer") || s.equals("Immortal") || s.equals("\"golden\""));
        assertTrue(anyMatch);

        List<String> searchedItemNames = marketPage.getSearchedItemNames();
        assertTrue(searchedItemNames.size() >= 5);

        boolean allMatchGolden = searchedItemNames.stream().limit(5).allMatch(s -> s.contains("Golden"));
        assertTrue(allMatchGolden);

        int itemCountBeforeDelete = marketPage.getItemCount();
        int filterSizeBeforeDelete = marketPage.getFilterSize();
        marketPage.removeGoldenFilter();
        assertEquals(marketPage.getFilterSize(), filterSizeBeforeDelete - 1);

        marketPage.removeDotaFilter();
        assertEquals(marketPage.getFilterSize(), filterSizeBeforeDelete - 2);

        int itemCountAfterDelete = marketPage.getItemCount();
        assertTrue(itemCountBeforeDelete <= itemCountAfterDelete);

        String firstItemName = marketPage.getFirstItemName();
        marketPage.clickOnFirstItem();

        assertEquals(itemPage.getGame(), "Dota 2");
        assertTrue(itemPage.getRarity().contains("Immortal"));
        assertTrue(itemPage.getItemName().contains("Golden"));
        assertTrue(itemPage.getHeroName().contains("Lifestealer"));

        assertTrue(firstItemName.contains(itemPage.getItemName()));
    }

    @AfterClass
    private void closeBrowser() {
        driver.close();
    }
}
