package com.onlineclothingstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private static WebDriver driver;

    @FindBy(css = ".products-grid > li")
    private List<WebElement> searchResultsItems;

    public SearchPage(WebDriver driver) {
        SearchPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfResults() {
        return searchResultsItems.size();
    }
}
