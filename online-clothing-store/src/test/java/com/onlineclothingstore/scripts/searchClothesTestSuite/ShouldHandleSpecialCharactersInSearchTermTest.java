package com.onlineclothingstore.scripts.searchClothesTestSuite;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.scripts.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShouldHandleSpecialCharactersInSearchTermTest extends BaseTest {

    @Test(groups = "search", dataProvider = "searchKeywordsWithSpecialCharacters", dataProviderClass = SearchData.class)
    public void handle(String keyword) {

        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int numberOfResults = catalogSearchPage.getNumberOfResults();
        System.out.println("Number of results: " + numberOfResults);

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
}
