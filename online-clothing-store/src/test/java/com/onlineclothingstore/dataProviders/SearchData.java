package com.onlineclothingstore.dataProviders;

import org.testng.annotations.DataProvider;

public class SearchData {
    @DataProvider(name = "searchKeywordsAndFilters")
    public static Object[][] createSearchKeywordsAndFilters() {
        return new Object[][] {
                {"shirt cotton", "Men"},
                {"pant for wearing", "Accessories"},
                {"shoes 1", "Home & Decor"},
        };
    }

    @DataProvider(name = "searchKeywordsWithNoResults")
    public static Object[][] createSearchKeywordsWithNoResults() {
        return new Object[][] {
                {"Lisa Simpson"},
                {"Wanda Nara"},
                {"Paulina Cocina"},
        };
    }
}
