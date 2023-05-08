package com.onlineclothingstore.scripts.search_clothes;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.HeaderPage;
import com.onlineclothingstore.pages.SearchPage;
import com.onlineclothingstore.pages.ShopByPage;
import org.testng.annotations.Test;

public class FilterSearchTest extends BaseTest {

    @Test(dataProvider = "searchKeywords", dataProviderClass = SearchData.class)
    public void handle(String keyword) {

        // todo: improve
        // - if succefullKeywordSearchTest is true => check if filterSearchTest works

        //succefullKeywordSearchTest
        driver.get("http://magento-demo.lexiconn.com");
        HeaderPage headerPage = new HeaderPage(driver);

        SearchPage searchPage = headerPage.searchFor(keyword);

        ShopByPage shopByPage = searchPage.applyFilter(filter);
        int numberOfResults = searchPage.getNumberOfResults();
        System.out.println("Number of results: " + numberOfResults);

        //filterSearchTest
        if (numberOfResults > 0) {
            ShopByPage shopByPage = new ShopByPage(driver);
            // for each filterAvailable, apply filter and check if number of results is > 0

            int numberOfResults = searchPage.getNumberOfResults();
        }


    }
}
