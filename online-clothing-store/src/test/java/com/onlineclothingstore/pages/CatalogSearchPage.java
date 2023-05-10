package com.onlineclothingstore.pages;

import com.onlineclothingstore.dataProviders.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CatalogSearchPage extends BasePage {

    @FindBy(css = ".products-grid .product-name")
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
    private WebElement SearchBreadcrumb;

    public CatalogSearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get the number of search results")
    public int getNumberOfResults() {
        return searchResultsItems.size();
    }

    @Step("Apply filter '{filter}'")
    public void applyFilter(String filter) {
        WebElement filterElement = findFilterElementByText(filter);
        if (filterElement != null) {
            filterElement.click();
        }
        new CatalogSearchPage(driver);
    }

    @Step("Find filter element by text '{filterText}'")
    private WebElement findFilterElementByText(String filterText) {
        for (WebElement filterOption : filterOptions) {
            if (filterOption.getText().contains(filterText)) {
                return filterOption;
            }
        }
        return null;
    }

    @Step("Get the number of filtered results")
    public int getNumberOfFilteredResults() {
        return searchResultsItems.size();
    }

    @Step("Check if filter '{filter}' is applied")
    public boolean isFilterApplied(String filter) {
        for (WebElement currentFilter : currentFilters) {
            if (currentFilter.getText().contains(filter)) {
                return true;
            }
        }
        return false;
    }

    @Step("Get the no results message")
    public String getNoResultsMessage() {
        return noResultsMessage.getText();
    }

    @Step("Get the search title")
    public String getSearchTitle() {
        return pageTitle.getText();
    }

    @Step("Get the search breadcrumb")
    public String getSearchBreadcrumb() {
        return SearchBreadcrumb.getText();
    }

    @Step("Click on random product")
    public DetailsProductPage clickOnProductRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(searchResultsItems.size());
        WebElement randomProduct = searchResultsItems.get(randomIndex);
        String selectedProductName = randomProduct.getText();
        randomProduct.click();
        return new DetailsProductPage(driver, selectedProductName);
    }

    @Step("Wait for search results")
    public void waitForSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResultsItems));
    }

}

