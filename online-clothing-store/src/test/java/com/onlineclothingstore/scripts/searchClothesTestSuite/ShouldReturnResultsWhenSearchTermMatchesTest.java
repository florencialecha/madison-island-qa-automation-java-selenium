package com.onlineclothingstore.scripts.searchClothesTestSuite;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.scripts.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldReturnResultsWhenSearchTermMatchesTest extends BaseTest {

    @Test(groups = "search", dataProvider = "searchKeywordsAndFilters", dataProviderClass = SearchData.class)
    public void handle(String keyword, String filter){
        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int numberOfResults = catalogSearchPage.getNumberOfResults();
        System.out.println("Number of results: " + numberOfResults);
        Assert.assertTrue(numberOfResults > 0, "No results found");
    }

}