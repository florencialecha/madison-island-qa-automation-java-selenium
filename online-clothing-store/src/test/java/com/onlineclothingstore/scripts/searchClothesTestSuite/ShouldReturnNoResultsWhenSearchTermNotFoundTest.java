package com.onlineclothingstore.scripts.searchClothesTestSuite;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.scripts.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldReturnNoResultsWhenSearchTermNotFoundTest extends BaseTest {
    @Test(groups = "search", dataProvider = "searchKeywordsWithNoResults", dataProviderClass = SearchData.class)
    public void handle(String keyword) {
        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int numberOfResults = catalogSearchPage.getNumberOfResults();
        System.out.println("Number of results: " + numberOfResults);
        Assert.assertEquals(numberOfResults, 0, "Search should return no results");
    }
}
