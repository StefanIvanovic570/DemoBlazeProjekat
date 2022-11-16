package com.code.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {

    private boolean cartIsEmpty = false;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean getCartIsEmpty() {
        return cartIsEmpty;
    }

    public void setCartIsEmpty(boolean cartIsEmpty) {
        this.cartIsEmpty = cartIsEmpty;
    }

    public WebElement getTotalPriceElement() {
        return (driver.findElement(By.id("totalp")));
    }

    public List<WebElement> getListOfBoughtItemsTable() {
        return driver.findElements(By.xpath("//td"));
    }

    public List<WebElement> getCartTableRowElements() {
        return driver.findElements(By.xpath("//tr"));
    }

    public WebElement getCartTableRowPriceElement(int row) {
        return getCartTableRowElements().get(row).findElement(By.xpath(".//td[3]"));
    }


    public int getCartTableRowPrice(int row) {
        return Integer.parseInt(getCartTableRowPriceElement(row).getText());
    }

    public void waitCartContents() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Delete']")));
    }

    public boolean checkIfCartIsEmpty() {
        if (getCartTableRowElements().size() > 1) {
            cartIsEmpty = false;
        } else {
            cartIsEmpty = true;
        }
        return cartIsEmpty;
    }

    public int sumOfPricesV2() {
        int toReturn = 0;
        for (int i = 1; i < getCartTableRowElements().size(); i++) {
            toReturn = toReturn + getCartTableRowPrice(i);
        }
        return toReturn;
    }
}
