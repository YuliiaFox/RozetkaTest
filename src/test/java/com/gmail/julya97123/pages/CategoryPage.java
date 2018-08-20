package com.gmail.julya97123.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    public WebDriver webDriver;

    public CategoryPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "(//li[@class='f-menu-l-i'] /a)[1] ")
    private WebElement categoryButton;

    @FindBy(xpath = "//h1[@class='pab-h1']")
    private WebElement categotyName;

    public String getCategoryHref() {
        return webDriver.getCurrentUrl();
    }

    public String getCategoryButtonHref() {
        return categoryButton.getAttribute("href");
    }

    public void clickCategoryButton() {
        categoryButton.click();
    }

}
