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
    @FindBy(css = "#narrow-by-list li a")
    private List<WebElement> filterOptions;
    @FindBy(css = ".currently .value")
    private List<WebElement> currentFilters;

    @FindBy(className = "note-msg")
    private WebElement noResultsMessage;

    @FindBy(className = "page-title")
    private WebElement pageTitle;

    @FindBy(className = "search")
    private WebElement searchRoot;

    public CatalogSearchPage(WebDriver driver) {
        CatalogSearchPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfResults() {
        return searchResultsItems.size();
    }

    public CatalogSearchPage applyFilter(String filter) {
        // 1 - find the filter on the filterOptions list
        WebElement filterElement = findFilterElementByText(filter);
        // 2 - click on the filter
        if (filterElement != null) {
            filterElement.click();
            System.out.println("Filter '" + filter + "' applied");
        } else {
            System.out.println("Filter '" + filter + " not found in the list of filters");
        }
        return new CatalogSearchPage(driver);
    }

    private WebElement findFilterElementByText(String filterText) {
        for (WebElement filterOption : filterOptions) {
            if (filterOption.getText().contains(filterText)) {
                return filterOption;
            }
        }
        return null;
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

    public String getNoResultsMessage() {
        return noResultsMessage.getText();
    }

    public String getSearchTitle() {
        return pageTitle.getText();
    }

    public String getSearchBreadcrumb() {
        return searchRoot.getText();
    }
}

