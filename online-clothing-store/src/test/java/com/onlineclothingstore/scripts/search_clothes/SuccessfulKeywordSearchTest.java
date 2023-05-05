package com.onlineclothingstore.scripts.search_clothes;

import com.onlineclothingstore.pages.SearchPage;
import com.onlineclothingstore.pages.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulKeywordSearchTest extends BaseTest {

    @Test
    public void handle(){
        driver.get("http://magento-demo.lexiconn.com");
        Header header = new Header(driver);
        SearchPage searchPage = header.searchFor("pants");
        int numberOfResults = searchPage.getNumberOfResults();
        System.out.println("Number of results: " + numberOfResults);
        Assert.assertTrue(numberOfResults > 0, "No results found");
    }

}
