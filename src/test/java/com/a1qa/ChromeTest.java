package com.a1qa;

import com.a1qa.pages.AboutPage;
import com.a1qa.pages.ItemPage;
import com.a1qa.pages.MainPage;
import com.a1qa.pages.MarketPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ChromeTest {
    private WebDriver driver;
    private MainPage mainPage;
    private AboutPage aboutPage;
    private MarketPage marketPage;
    private ItemPage itemPage;

    @BeforeMethod
    public void setupClass() {
        driver = DriverManager.getInstance().openBrowser();

        mainPage = new MainPage();
        aboutPage = new AboutPage();
        marketPage = new MarketPage();
        itemPage = new ItemPage();
    }

    @Test
    public void testCaseOne() {
        assertDoesNotThrow("Main page does not load", () ->
                mainPage.openMainPage()
        );

        assertDoesNotThrow("About page does not load", () -> mainPage.clickAboutBtn());

        long countOnline = aboutPage.getCountOnline();
        long countPlaying = aboutPage.getCountPlaying();

        assertTrue(countOnline > countPlaying, "The number of players is more than online");

        assertDoesNotThrow("Store page does not load", () -> aboutPage.clickStoreBtn());
    }

    @Test
    public void testCaseThree() {
        assertDoesNotThrow("Main page does not load", () ->
                mainPage.openMainPage()
        );
        mainPage.moveMouseToCommunity();
        double opacity = mainPage.getCommunitySubmenuOpacity();
        assertTrue(opacity > 0.5, "The submenu did not appear");
        assertDoesNotThrow("Market page does not load", () -> mainPage.clickCommunitySubmenuMarket());
        assertDoesNotThrow("Search form does not load", () -> marketPage.clickAdvancedOptionsBtn());
        marketPage.clickListGames();

        assertDoesNotThrow("Hero does not load", () -> marketPage.clickGame());

        marketPage.clickHeroList();

        marketPage.clickHero();

        marketPage.clickRarity();

        marketPage.sendGolden();

        marketPage.clickSearchBtn();

        List<String> filtersText = marketPage.getFiltersText();
        boolean anyMatch = filtersText.stream()
                .anyMatch(s -> s.equals("Dota 2") || s.equals("Lifestealer") || s.equals("Immortal") || s.equals("\"golden\""));
        assertTrue(anyMatch, "Search filters did not appear");

        List<String> searchedItemNames = marketPage.getSearchedItemNames();
        assertTrue(searchedItemNames.size() >= 5, "Less than five results were found");

        boolean allMatchGolden = searchedItemNames.stream().limit(5).allMatch(s -> s.contains("Golden"));
        assertTrue(allMatchGolden, "The first five results do not contain the word \"Golden\" in the title.");

        int itemCountBeforeDelete = marketPage.getItemCount();
        int filterSizeBeforeDelete = marketPage.getFilterSize();
        marketPage.removeGoldenFilter();
        assertEquals(marketPage.getFilterSize(), filterSizeBeforeDelete - 1, "Unable to remove the filter 'golden'");

        marketPage.removeDotaFilter();
        assertEquals(marketPage.getFilterSize(), filterSizeBeforeDelete - 2, "Unable to remove the filter 'dota 2'");

        int itemCountAfterDelete = marketPage.getItemCount();
        assertTrue(itemCountBeforeDelete <= itemCountAfterDelete, "The list of items has not been updated");

        String firstItemName = marketPage.getFirstItemName();
        marketPage.clickOnFirstItem();

        assertTrue(itemPage.getRarity().contains("Immortal"), "Item information does not match the filter");
        assertTrue(itemPage.getHeroName().contains("Lifestealer"), "Item information does not match the filter");

        assertTrue(firstItemName.contains(itemPage.getItemName()), "The name of the item does not match the name of the item from the previous page");
    }

    @AfterMethod
    private void closeBrowser() {
        driver.quit();
    }

    private void assertDoesNotThrow(String errorMessage, Runnable f) {
        try {
            f.run();
        } catch (Exception e) {
            fail(errorMessage, e);
        }
    }
}
