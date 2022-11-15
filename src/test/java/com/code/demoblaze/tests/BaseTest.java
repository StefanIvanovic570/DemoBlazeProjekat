package com.code.demoblaze.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void classSetup() {
        System.setProperty("webdriver.chrome.driver", "F:\\aKurs COMTRADE\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void classTeardown() {
        driver.close();
        driver.quit();
    }
}
