package com.code.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtnAddToCart() {
        return driver.findElement(By.xpath("//a[text()='Add to cart']"));
    }

    public void waitBtnAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));
    }

    public void handleAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
