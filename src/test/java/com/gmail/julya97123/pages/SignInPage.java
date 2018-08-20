package com.gmail.julya97123.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    public WebDriver webDriver;

    public SignInPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@name='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "(//div[@class='auth-f-i']/input)[1]")
    private WebElement loginField;

    @FindBy(xpath = "(//div[@class='auth-f-i']/input)[2]")
    private WebElement passField;

    @FindBy(xpath = "//span[@class='btn-link btn-link-blue']/button")
    private WebElement submitButton;

    private WebElement closeMessage;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String pass) {
        passField.sendKeys(pass);
    }

    public void clickSignInForm() {
        signInButton.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickToCloseMessage() {
        closeMessage = waitingLoadElement("//div[@class='social-bind social-bind-tiny']/a");
        closeMessage.click();
    }

    private WebElement waitingLoadElement(String xpathString) throws WebDriverException {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(xpathString)));
    }
}
