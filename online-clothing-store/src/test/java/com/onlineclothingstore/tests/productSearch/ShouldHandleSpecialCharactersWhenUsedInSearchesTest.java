package com.onlineclothingstore.tests.productSearch;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.pages.HeaderPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShouldHandleSpecialCharactersWhenUsedInSearchesTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Feature("Search Product Functionality")
    @Story("Handle special characters in search term")
    @Description("When a user searches for a product using special characters, the search results should be displayed correctly.")
    @Test(groups = "search", dataProvider = "searchKeywordsWithSpecialCharacters", dataProviderClass = SearchData.class)
    public void handle(String keyword) {

        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int numberOfResults = catalogSearchPage.getNumberOfResults();

        String expectedSearchTitle = "SEARCH RESULTS FOR '" + keyword.toUpperCase() + "'";
        String actualSearchTitle = catalogSearchPage.getSearchTitle();
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle, "The search title should be displayed correctly");

        String expectedSearchBreadcrumb = "SEARCH RESULTS FOR: '" + keyword.toUpperCase() + "'";
        String actualSearchBreadcrumb = catalogSearchPage.getSearchBreadcrumb();
        Assert.assertEquals(actualSearchBreadcrumb, expectedSearchBreadcrumb, "The search breadcrumb should be displayed correctly");

        if (numberOfResults > 0) {
            Assert.assertTrue(numberOfResults > 0, "Results found");
        } else {
            String expectedNoResultsMessage = "Your search returns no results.";
            String actualNoResultsMessage = catalogSearchPage.getNoResultsMessage();
            Assert.assertEquals(actualNoResultsMessage, expectedNoResultsMessage, "The no results message should be displayed");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
