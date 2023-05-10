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

public class ShouldReturnNoResultsWhenNonExistingItemSearchedTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Feature("Search Product Functionality")
    @Story("Search for a product that doesn't exist")
    @Description("When a user searches for a product that doesn't exist, the search should return no results.")
    @Test(groups = "search", dataProvider = "searchKeywordsWithNoResults", dataProviderClass = SearchData.class)
    public void handle(String keyword) {

        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int numberOfResults = catalogSearchPage.getNumberOfResults();
        Assert.assertEquals(numberOfResults, 0, "Search should return no results");

        String expectedSearchTitle = "SEARCH RESULTS FOR '" + keyword.toUpperCase() + "'";
        String actualSearchTitle = catalogSearchPage.getSearchTitle();
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle, "The search title don't match");

        String expectedSearchBreadcrumb = "SEARCH RESULTS FOR: '" + keyword.toUpperCase() + "'";
        String actualSearchBreadcrumb = catalogSearchPage.getSearchBreadcrumb();
        Assert.assertEquals(actualSearchBreadcrumb, expectedSearchBreadcrumb, "The search breadcrumb don't match");

        String expectedNoResultsMessage = "Your search returns no results.";
        String actualNoResultsMessage = catalogSearchPage.getNoResultsMessage();
        Assert.assertEquals(actualNoResultsMessage, expectedNoResultsMessage, "The no results message should be displayed");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
