package com.onlineclothingstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogSearchPage {
    private static WebDriver driver;
    @FindBy(css = ".products-grid > li")
    private List<WebElement> searchResultsItems;
    @FindBy(css = "#narrow-by-list > li")
    private List<WebElement> filterOptions;
    @FindBy(css = ".currently > li")
    private List<WebElement> currentFilters;

    public CatalogSearchPage(WebDriver driver) {
        CatalogSearchPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfResults() {
        return searchResultsItems.size();
    }

    public CatalogSearchPage applyFilter(String filter) {

        WebElement filterToApply = null;

        for (WebElement option : filterOptions) {
            if (option.getText().contains(filter)) {
                filterToApply = option;
                break;
            }
        }

        if (filterToApply != null) {
            filterToApply.click();
        } else {
            System.out.println("Filter not found: " + filter);
        }

        return this;
    }

    public int getNumberOfFilteredResults() {
        return searchResultsItems.size();
    }

    public boolean isFilterApplied(String filter) {
        System.out.println("Filter to check: " + filter);
        for (WebElement currentFilter : currentFilters) {
            if (currentFilter.getText().contains(filter)) {
                return true;
            }
        }
        return false;
    }
}
