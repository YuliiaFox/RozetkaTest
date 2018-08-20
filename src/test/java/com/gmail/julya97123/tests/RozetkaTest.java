package com.gmail.julya97123.tests;

import com.gmail.julya97123.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class RozetkaTest {
    private static WebDriver webDriver;
   // private static WebDriverWait wait;
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
        //wait = new WebDriverWait(webDriver, 10);
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
       // WebElement signInButton = webDriver.findElement(By.xpath("//a[@name='signin']"));
        //signInButton.click();

        //WebElement loginField = webDriver.findElement(By.xpath("(//div[@class='auth-f-i']/input)[1]"));
        //loginField.sendKeys("yuliialysenko97@gmail.com");

        //WebElement passField = webDriver.findElement(By.xpath("(//div[@class='auth-f-i']/input)[2]"));
        //passField.sendKeys("Yuliia97");

       // WebElement submitButton = webDriver.findElement(By.xpath("//span[@class='btn-link btn-link-blue']/button"));
        //submitButton.click();

        //waiting while signIn page is loading
       // WebElement closeMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='social-bind social-bind-tiny']/a")));
       // closeMessage.click();
    }

    @org.testng.annotations.Test(priority = 2)
    public void category() {
        categoryPage.clickCategoryButton();
        //WebElement category = webDriver.findElement(By.xpath("(//li[@class='f-menu-l-i'] /a)[1] "));
       // category.click();
        closeBanner();
        Assert.assertEquals(categoryPage.getCategoryButtonHref(),categoryPage.getCategoryHref());
       // WebElement categotyName = webDriver.findElement(By.xpath("//h1[@class='pab-h1']"));
        //String categoryNameContainer = categotyName.getText();
       // Assert.assertEquals(categoryNameContainer, "Комп'ютери та ноутбуки");
        //webDriver.get("https://rozetka.com.ua/ua/");
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

        //WebElement manufacturer = webDriver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/v004/']"));
        //manufacturer.click();

        //WebElement goodsName = webDriver.findElement(By.xpath("//div[@class='g-i-tile-i-title clearfix']"));
        //String goodsNameString = goodsName.getText();

       // WebElement addToCartButton = webDriver.findElement(By.xpath("//button[@class='btn-link-i']"));
       // addToCartButton.click();
        //waiting while cart page is loading
       // WebElement cartPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
       //         By.xpath("//div[@class='wrap-cart-not-empty  with-cart-amount']")));

      //  WebElement cartGoods = webDriver.findElement(By.xpath("//a[@class='novisited cart-i-title-link']"));
       // Assert.assertEquals(goodsNameString, cartGoods.getText());

        //WebElement optionButton = webDriver.findElement(By.xpath("//a[@class='cart-check']"));
        //optionButton.click();

        //WebElement deleteButton = webDriver.findElement(By.xpath("//a[@name='delete']"));
       // deleteButton.click();

        //waiting while goods is deleting from cart
       // WebElement closeMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='empty-cart-title inline sprite-side']")));
        //closeMessage.click();
        //close empty cart
        //webDriver.findElement(By.xpath("//img[@class='popup-close-icon sprite'] ")).click();
    }

    @org.testng.annotations.AfterClass
    public static void tearDown() {
      //  WebElement profileButton = webDriver.findElement(By.xpath("//a[@name='profile']"));
       // profileButton.click();
       // WebElement logOut = webDriver.findElement(By.xpath("//a[@class='profile-m-edit-signout']"));
       // logOut.click();

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
