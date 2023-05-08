package com.onlineclothingstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShopByPage {

    private static WebDriver driver;

    //Criteria (dynimic selector) for shop by available options
        //Options for shop by criteria

    @FindBy(css = ".last odd current > li")
    private List<WebElement> availableFilters; //save a list like: Men, Black, 10

    public ShopByPage(WebDriver driver) {
        ShopByPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getAvailableFilters() {
        List<String> availableFiltersText = new ArrayList<>();
        availableFilters.get(0).getText();
        return availableFiltersText;
    }
}
