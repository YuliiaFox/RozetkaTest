package com.gmail.julya97123.tests;

import com.gmail.julya97123.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class RozetkaTest {
    private static WebDriver webDriver;
    private static CartPage cartPage;
    private static CategoryPage categoryPage;
    private static ProductPage productPage;
    private static SignInPage signInPage;
    private static SingOutPage singOutPage;

    @org.testng.annotations.BeforeClass
    public static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                "E:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        cartPage = new CartPage(webDriver);
        categoryPage = new CategoryPage(webDriver);
        productPage = new ProductPage(webDriver);
        signInPage = new SignInPage(webDriver);
        singOutPage = new SingOutPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get("https://rozetka.com.ua/ua/");
    }

    @org.testng.annotations.Test(priority = 1)

    public void signIn() {
        closeBanner();
        signInPage.clickSignInForm();
        signInPage.inputLogin("yuliialysenko97@gmail.com");
        signInPage.inputPassword("Yuliia97");
        signInPage.clickSubmitButton();
        signInPage.clickToCloseMessage();
    }

    @org.testng.annotations.Test(priority = 2)
    public void category() {
        categoryPage.clickCategoryButton();
        closeBanner();
        Assert.assertEquals(categoryPage.getCategoryButtonHref(), categoryPage.getCategoryHref());

    }

    @org.testng.annotations.Test(priority = 3)
    public void chooseAndAddGoods() {
        productPage.clickManufacturerButton();
        productPage.clickAddToCartButton();

        Assert.assertEquals(productPage.getProductName(), cartPage.getNameProductFromCart());
        cartPage.clickMenuButton();
        cartPage.clickDeleteProductButton();
        cartPage.clickCloseCartButton();
        cartPage.clickCloseCartPageButton();
    }

    @org.testng.annotations.AfterClass
    public static void tearDown() {
        singOutPage.clickProfileButton();
        singOutPage.clickLogOutButton();
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    private void closeBanner() {
        try {
            WebElement closeBanner = webDriver.findElement(By.xpath("//span[@class='exponea-close-cross']"));
            closeBanner.click();
        } catch (WebDriverException e) {
            System.out.println("Element not found");
        }
    }
}
