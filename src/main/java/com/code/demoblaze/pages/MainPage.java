package com.code.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    public WebElement getProductByName(String productName) {
        return driver.findElement(By.xpath("//a[text()='" + productName + "']"));
    }

    public WebElement getBtnCart() {
        return driver.findElement(By.id("cartur"));
    }

    //Fields
    public WebElement getInputLogInUsername() {
        return driver.findElement(By.id("loginusername"));
    }

    public WebElement getInputLogInPassword() {
        return driver.findElement(By.id("loginpassword"));
    }

    //Buttons
    public WebElement getBtnHome() {
        return driver.findElement(By.xpath("//a[text()='Home ']"));
    }

    public WebElement getBtnLogIn() {
        return driver.findElement(By.id("login2"));
    }

    public WebElement getBtnLogOut() {
        return driver.findElement(By.id("logout2"));
    }

    public WebElement getBtnLogInWithCredentials() {
        return driver.findElement(By.xpath("//button[text()='Log in']"));
    }

    public WebElement getBtnNextProductPage() {
        return driver.findElement(By.xpath("//button[text()='Next']"));
    }

    //Waits
    public void waitBtnLogInWithCredentials() {
        wait.until(ExpectedConditions.elementToBeClickable(this.getBtnLogInWithCredentials()));
    }

    public void waitBtnLogOut() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Log out']")));
    }

    public void waitBtnPrevious() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Previous']")));
    }
    public void waitProduct(String productName){
        wait.until(ExpectedConditions.elementToBeClickable(getProductByName(productName)));
    }
    public void waitBtnNext(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("next2")));
    }

    //Other Methods

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


    public boolean elementIsVisible(String productName) {
        try {
            getProductByName(productName).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnProductByName(String productName) {

        while (!elementIsVisible(productName)) {
            waitBtnNext();
            getBtnNextProductPage().click();
            waitBtnPrevious();
        }
        waitProduct(productName);
        getProductByName(productName).click();
    }
}

