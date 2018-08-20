package com.gmail.julya97123.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/v004/']")
    private WebElement manufacturer;
    @FindBy(xpath = "//div[@class='g-i-tile-i-title clearfix']")
    private WebElement product;
    @FindBy(xpath = "//button[@class='btn-link-i']")
    private WebElement addToCartButton;

    public void clickManufacturerButton() {
        manufacturer.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getProductName() {
        return product.getText();
    }

}
