package com.onlineclothingstore.dataProviders;

import org.testng.annotations.DataProvider;

public class SearchData {
    @DataProvider(name = "searchKeywordsAndFilters")
    public static Object[][] createSearchKeywordsAndFilters() {
        return new Object[][] {
                {"pants", "Women"},
                {"shirt", "Men"},
                {"shoes", "Black"},
        };
    }
}
