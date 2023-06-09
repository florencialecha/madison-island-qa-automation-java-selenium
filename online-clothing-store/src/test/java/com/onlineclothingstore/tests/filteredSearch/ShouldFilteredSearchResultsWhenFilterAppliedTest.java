package com.onlineclothingstore.tests.filteredSearch;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.pages.CatalogSearchPage;
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

public class ShouldFilteredSearchResultsWhenFilterAppliedTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Feature("Filter Search Results Functionality")
    @Story("Filter search results by criteria")
    @Description("When a user searches for a product and applies a filter, the results should be filtered correctly.")
    @Test(dataProvider = "searchKeywordsAndFilters", dataProviderClass = SearchData.class)
    public void handle(String keyword,  String filter) {

        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);

        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int countSearchForKeywordResults = catalogSearchPage.getNumberOfResults();

        if (countSearchForKeywordResults > 0) {
            catalogSearchPage.applyFilter(filter);
            int countApplyFilterResults = catalogSearchPage.getNumberOfFilteredResults();
            Assert.assertTrue(catalogSearchPage.isFilterApplied(filter), "Filter not applied");
            Assert.assertTrue(countApplyFilterResults <= countSearchForKeywordResults, "Filtered results exceed the initial search results");
        } else {
            Assert.fail("No results found for the given keyword");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
