package com.onlineclothingstore.pages;

import com.onlineclothingstore.dataProviders.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;
public class HeaderPage extends BasePage {

    @FindBy(css = "#search_mini_form input")
    private WebElement searchBar;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Search for product with keyword: {keyword}")
    public CatalogSearchPage searchFor(String keyword) {
        searchBar.sendKeys(keyword);
        searchBar.sendKeys(ENTER);
        return new CatalogSearchPage(driver);
    }

}
