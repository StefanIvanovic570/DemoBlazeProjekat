package com.code.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class MainPage {
    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //Mapiranje

    public WebElement getBtnLogIn() {
        return driver.findElement(By.id("login2"));
    }

    public WebElement getBtnLogOut() {
        return driver.findElement(By.id("logout2"));
    }

    public WebElement getInputLogInUsername() {
        return driver.findElement(By.id("loginusername"));
    }

    public WebElement getInputLogInPassword() {
        return driver.findElement(By.id("loginpassword"));
    }

    public WebElement getBtnLogInWithCredentials() {
        return driver.findElement(By.xpath("//button[text()='Log in']"));
    }

    public WebElement getBtnNextProductPage() {
        return driver.findElement(By.xpath("//button[text()='Next']"));
    }

    public WebElement getBtnAddToCart() {
        return driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
    }

    //Ostale metode

    public void openMainPage() {
        this.driver.get("https://www.demoblaze.com/");
        this.driver.manage().window().maximize();
    }

    public void inputUserName(String username) {
        this.getInputLogInUsername().sendKeys(username);
    }

    public void inputPassword(String password) {
        this.getInputLogInPassword().sendKeys(password);
    }

    public void waitBtnLogInWithCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.elementToBeClickable(this.getBtnLogInWithCredentials()));
    }

    public void waitForLoading(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void addItemToCartByName(String productName) throws InterruptedException {
        HashMap<String, String> productList = new HashMap<>();
        boolean nextPageExists = true;
        do {
            List<WebElement> pageList = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
            for (int j = 0; j < pageList.size(); j++) {
                WebElement product = pageList.get(j).findElement(By.xpath(".//a[@class='hrefch']"));
                String productText = product.getText();
                String productLink = product.getAttribute("href");
                productList.put(productText, productLink);
            }
            if (getBtnNextProductPage().isDisplayed()) {
                getBtnNextProductPage().click();
                waitForLoading(2000);
            } else {
                nextPageExists = false;
            }

        }
        while (nextPageExists);
        driver.get(productList.get(productName));
        waitForLoading(2000);
        getBtnAddToCart().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

