package com.gmail.julya97123.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingOutPage {
    public WebDriver webDriver;

    public SingOutPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@name='profile']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[@class='profile-m-edit-signout']")
    private WebElement logOutButton;

    public void clickProfileButton() {
        profileButton.click();
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }
}
