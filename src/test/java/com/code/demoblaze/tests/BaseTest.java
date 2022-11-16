package com.code.demoblaze.tests;

import com.code.demoblaze.pages.CartPage;
import com.code.demoblaze.pages.MainPage;
import com.code.demoblaze.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    protected MainPage mainPage;
    protected CartPage cartPage;
    protected ProductPage productPage;

    @BeforeClass
    public void classSetup() {
        System.setProperty("webdriver.chrome.driver", "F:\\aKurs COMTRADE\\chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
    }

    @AfterClass
    public void classTeardown() {
        driver.close();
        driver.quit();
    }
}
