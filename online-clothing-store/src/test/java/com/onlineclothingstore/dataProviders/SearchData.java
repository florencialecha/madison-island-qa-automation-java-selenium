package com.onlineclothingstore.dataProviders;

import org.testng.annotations.DataProvider;

public class SearchData {
    @DataProvider(name = "searchKeywords")
    public static Object[][] searchKeywords() {
        return new Object[][] {
                {"pants"},
                {"shirt"},
                {"shoes"},
        };
    }
}
