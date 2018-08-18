package com.gmail.julya97123.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignInTest {
    private static WebDriver webDriver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setWebDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().fullscreen();
        wait = new WebDriverWait(webDriver, 5);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void signInOut() {
        //closeBanner();
        WebElement signInButton = webDriver.findElement(By.xpath("//a[@name='signin']"));
        signInButton.click();

        WebElement loginField = webDriver.findElement(By.xpath("(//div[@class='auth-f-i']/input)[1]"));
        loginField.sendKeys("yuliialysenko97@gmail.com");

        WebElement passField = webDriver.findElement(By.xpath("(//div[@class='auth-f-i']/input)[2]"));
        passField.sendKeys("Yuliia97");

        WebElement submitButton = webDriver.findElement(By.xpath("//span[@class='btn-link btn-link-blue']/button"));
        submitButton.click();

        //waiting while signIn page is loading
        WebElement closeMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='social-bind social-bind-tiny']/a")));
        closeMessage.click();

        WebElement profileButton = webDriver.findElement(By.xpath("//a[@name='profile']"));
        profileButton.click();
        WebElement logOut = webDriver.findElement(By.xpath("//a[@class='profile-m-edit-signout']"));
        logOut.click();
    }
}
