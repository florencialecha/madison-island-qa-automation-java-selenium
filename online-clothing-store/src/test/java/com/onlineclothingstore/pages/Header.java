package com.onlineclothingstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;
public class Header {
    private static WebDriver driver;
    //todo: check if selector name = q is better, it's more specific but less readable
    @FindBy(css = "#search_mini_form input")
    private WebElement searchBar;

    public Header(WebDriver driver) {
        Header.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage searchFor(String keyword) {
        searchBar.sendKeys(keyword);
        searchBar.sendKeys(ENTER);
        return new SearchPage(driver);
    }
}
