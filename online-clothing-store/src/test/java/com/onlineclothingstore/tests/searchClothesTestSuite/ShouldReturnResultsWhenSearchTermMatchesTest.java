package com.onlineclothingstore.tests.searchClothesTestSuite;

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

public class ShouldReturnResultsWhenSearchTermMatchesTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Feature("Search Product Functionality")
    @Story("Search for a product that exists")
    @Description("When a user searches for a product that exists, the search should return results.")
    @Test(groups = "search", dataProvider = "searchKeywordsAndFilters", dataProviderClass = SearchData.class)
    public void handle(String keyword, String filter){

        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int numberOfResults = catalogSearchPage.getNumberOfResults();
        Assert.assertTrue(numberOfResults > 0, "No results found");

        String expectedSearchTitle = "SEARCH RESULTS FOR '" + keyword.toUpperCase() + "'";
        String actualSearchTitle = catalogSearchPage.getSearchTitle();
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle, "The search title don't match");

        String expectedSearchBreadcrumb = "SEARCH RESULTS FOR: '" + keyword.toUpperCase() + "'";
        String actualSearchBreadcrumb = catalogSearchPage.getSearchBreadcrumb();
        Assert.assertEquals(actualSearchBreadcrumb, expectedSearchBreadcrumb, "The search breadcrumb don't match");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
