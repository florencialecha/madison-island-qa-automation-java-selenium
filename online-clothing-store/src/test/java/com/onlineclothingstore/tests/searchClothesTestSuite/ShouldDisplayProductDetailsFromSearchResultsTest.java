package com.onlineclothingstore.tests.searchClothesTestSuite;

import com.onlineclothingstore.dataProviders.SearchData;
import com.onlineclothingstore.pages.CatalogSearchPage;
import com.onlineclothingstore.pages.DetailsProductPage;
import com.onlineclothingstore.pages.HeaderPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShouldDisplayProductDetailsFromSearchResultsTest {

    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Feature("Product Details Display")
    @Story("Display product details from search results")
    @Description("When a user searches for a product and selects one from the search results, the details of the product should be displayed correctly.")
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

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
