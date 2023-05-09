package com.onlineclothingstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailsProductPage {
    private static WebDriver driver;
    private final String selectedProductName;
    @FindBy(css = ".product-name .h1")
    private WebElement productName;

    @FindBy(css = ".breadcrumbs .product")
    private WebElement searchBreadcrumb;

    public DetailsProductPage(WebDriver driver, String selectedProductName) {
        DetailsProductPage.driver = driver;
        PageFactory.initElements(driver, this);
        this.selectedProductName = selectedProductName;
    }

    public String getProductName() {
            System.out.println("Product name: " + productName.getText());
            return productName.getText();
    }

    public String getSearchBreadcrumb() {
            return searchBreadcrumb.getText();
    }

    public String getSelectedProductName() {
            return selectedProductName;
    }

    public void waitForPageTitle() {
        // wait for the page title to be displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(productName));
    }
}
