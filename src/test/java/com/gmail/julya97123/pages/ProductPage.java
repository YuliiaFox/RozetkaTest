package com.gmail.julya97123.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage {
    public WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/v004/']")
    private WebElement manufacturer;
    @FindBy(xpath = "//div[@class='g-i-tile-i-title clearfix']")
    private WebElement product;
    @FindBy(xpath = "//button[@class='btn-link-i']")
    private WebElement addToCartButton;

    public void clickManufacturerButton(){
        manufacturer.click();
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    public String getProductName(){
        return product.getText();
    }

    /*protected void load() {
        new WebDriverWait(webDriver,10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='wrap-cart-not-empty  with-cart-amount']")));
    }

    protected void isLoaded() throws Error {
        if(webDriver.findElement(By.xpath("//div[@class='wrap-cart-not-empty  with-cart-amount']")).isDisplayed()){
            System.out.println("Cart is open");
        }
    }*/
}
