package com.onlineclothingstore.pages;

import com.onlineclothingstore.dataProviders.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailsProductPage extends BasePage {
    private final String selectedProductName;
    @FindBy(css = ".product-name .h1")
    private WebElement productName;
    @FindBy(css = ".breadcrumbs .product")
    private WebElement searchBreadcrumb;

    public DetailsProductPage(WebDriver driver, String selectedProductName) {
        super(driver);
        this.selectedProductName = selectedProductName;
    }

    @Step("Get product name")
    public String getProductName() {
        return productName.getText();
    }

    @Step("Get search breadcrumb")
    public String getSearchBreadcrumb() {
        return searchBreadcrumb.getText();
    }

    @Step("Wait for page title")
    public String getSelectedProductName() {
        return selectedProductName;
    }

    @Step("Wait for page title to be displayed")
    public void waitForPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(productName));
    }

}
