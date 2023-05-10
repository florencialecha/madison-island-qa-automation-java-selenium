package com.onlineclothingstore.scripts.searchClothesTestSuite;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.scripts.utils.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldReturnNoResultsWhenSearchTermNotFoundTest extends BaseTest {

    @Feature("Search Product Functionality")
    @Story("Search for a product that doesn't exist")
    @Description("When a user searches for a product that doesn't exist, the search should return no results.")
    @Test(groups = "search", dataProvider = "searchKeywordsWithNoResults", dataProviderClass = SearchData.class)
    public void handle(String keyword) {

        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int numberOfResults = catalogSearchPage.getNumberOfResults();
        System.out.println("Number of results: " + numberOfResults);
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
}
