package com.gmail.julya97123.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    public WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    private WebElement productFromCart;
    private WebElement closeCartButton;
    @FindBy(xpath = "//a[@class='cart-check']")
    private WebElement menuButton;
    @FindBy(xpath = "//a[@name='delete']")
    private WebElement deleteProductButton;
    @FindBy(xpath = "//img[@class='popup-close-icon sprite'] ")
    private WebElement closeCartPageButton;

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickDeleteProductButton() {
        deleteProductButton.click();
    }

    public String getNameProductFromCart() {
        loadCartPage();
        return productFromCart.getText();
    }

    public void clickCloseCartButton() {
        loadDeletingProductFromCartButton();
        closeCartButton.click();
    }

    public void clickCloseCartPageButton() {
        closeCartPageButton.click();
    }

    private void loadCartPage() {
        productFromCart = waitingLoadElement("//a[@class='novisited cart-i-title-link']");
    }

    private void loadDeletingProductFromCartButton() {
        closeCartButton = waitingLoadElement("//h2[@class='empty-cart-title inline sprite-side']");

    }

    private WebElement waitingLoadElement(String xpathString) throws WebDriverException {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(xpathString)));
    }

}
