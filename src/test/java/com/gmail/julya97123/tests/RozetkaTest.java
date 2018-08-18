package com.gmail.julya97123.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RozetkaTest {
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
    public void Category() {
        openCategory();
        //closeBanner();
        WebElement categotyName = webDriver.findElement(By.xpath("//h1[@class='pab-h1']"));
        String categoryNameContainer = categotyName.getText();
        Assert.assertEquals(categoryNameContainer, "Комп'ютери та ноутбуки");
        webDriver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void chooseAndAddGoods() {
        openCategory();
        WebElement manufacturer = webDriver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/v004/']"));
        manufacturer.click();

        WebElement goodsName = webDriver.findElement(By.xpath("//div[@class='g-i-tile-i-title clearfix']"));
        String goodsNameString = goodsName.getText();

        WebElement addToCartButton = webDriver.findElement(By.xpath("//button[@class='btn-link-i']"));
        addToCartButton.click();
        //waiting while cart page is loading
        WebElement cartGoods = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='novisited cart-i-title-link']")));
        Assert.assertEquals(goodsNameString, cartGoods.getText());

        WebElement optionButton = webDriver.findElement(By.xpath("//a[@class='cart-check']"));
        optionButton.click();

        WebElement deleteButton = webDriver.findElement(By.xpath("//a[@name='delete']"));
        deleteButton.click();

        //waiting while goods is deleting from cart
        WebElement closeMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='empty-cart-title inline sprite-side']")));
        closeMessage.click();

        webDriver.get("https://rozetka.com.ua/ua/");
    }

    @AfterClass
    public static void tearDown() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    private void openCategory() {
        WebElement category = webDriver.findElement(By.xpath("(//li[@class='f-menu-l-i'] /a)[1] "));
        category.click();
    }

    private void closeBanner() {
        WebElement banner = webDriver.findElement(By.xpath("//span[@class='exponea-close-cross']"));
        if (banner.isDisplayed()) {
            banner.click();
        }
    }


}
