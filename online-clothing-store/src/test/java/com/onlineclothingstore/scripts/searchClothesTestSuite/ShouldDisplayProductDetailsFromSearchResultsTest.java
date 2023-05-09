package com.onlineclothingstore.scripts.searchClothesTestSuite;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.pages.DetailsProductPage;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.scripts.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldDisplayProductDetailsFromSearchResultsTest extends BaseTest {

    @Test(dataProvider = "searchKeywordsAndFilters", dataProviderClass = SearchData.class)
    public void handle(String keyword, String filter) {

        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);
        CatalogSearchPage catalogSearchPage = headerPage.searchFor(keyword);
        catalogSearchPage.waitForSearchResults();

        DetailsProductPage detailsProductPage = catalogSearchPage.clickOnProductRandom();
        String selectedProductName = detailsProductPage.getSelectedProductName();
        detailsProductPage.waitForPageTitle();

        String expectedPageTitle = detailsProductPage.getProductName();
        String actualPageTitle = selectedProductName;
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "The page title should match the selected product's name");

        String expectedSearchBreadcrumb = selectedProductName.toUpperCase();
        String actualSearchBreadcrumb = detailsProductPage.getSearchBreadcrumb();
        Assert.assertEquals(actualSearchBreadcrumb, expectedSearchBreadcrumb, "The search breadcrumb should match the selected product's name");
    }

}
