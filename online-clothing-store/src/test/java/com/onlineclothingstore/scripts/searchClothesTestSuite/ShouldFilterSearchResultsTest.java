package com.onlineclothingstore.scripts.searchClothesTestSuite;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.scripts.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldFilterSearchResultsTest extends BaseTest {

    @Test(dataProvider = "searchKeywordsAndFilters", dataProviderClass = SearchData.class)
    public void handle(String keyword,  String filter) {

        // improve: if succefullKeywordSearchTest is true => check if filterSearchTest works
        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);

        // Perform a search using the provided keyword
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        int countSearchForKeywordResults = catalogSearchPage.getNumberOfResults();
        System.out.println("Number of results for keyword search: " + countSearchForKeywordResults);

        // Apply the provided filter and get the number of filtered results
        if (countSearchForKeywordResults > 0) {

            System.out.println("Applying filter: " + filter + "...");
            catalogSearchPage.applyFilter(filter);

            int countApplyFilterResults = catalogSearchPage.getNumberOfFilteredResults();
            System.out.println("Number of results for filter search: " + countApplyFilterResults);

            Assert.assertTrue(catalogSearchPage.isFilterApplied(filter), "Filter not applied");
            Assert.assertTrue(countApplyFilterResults <= countSearchForKeywordResults, "Filtered results exceed the initial search results");
        } else {
            Assert.fail("No results found for the given keyword");
        }
    }
}
