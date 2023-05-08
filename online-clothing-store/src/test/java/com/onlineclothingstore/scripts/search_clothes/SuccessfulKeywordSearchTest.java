package com.onlineclothingstore.scripts.search_clothes;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.SearchPage;
import com.onlineclothingstore.pages.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulKeywordSearchTest extends BaseTest {

    @Test(dataProvider = "searchKeywords", dataProviderClass = SearchData.class)
    public void handle(String keyword){
        driver.get("http://magento-demo.lexiconn.com");
        Header header = new Header(driver);
        SearchPage searchPage = header.searchFor(keyword);
        int numberOfResults = searchPage.getNumberOfResults();
        System.out.println("Number of results: " + numberOfResults);
        Assert.assertTrue(numberOfResults > 0, "No results found");
    }

}
