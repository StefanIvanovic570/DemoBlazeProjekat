package com.code.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private boolean cartIsEmpty = false;
    private WebDriver driver;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getCartIsEmpty() {
        return cartIsEmpty;
    }

    public void setCartIsEmpty(boolean cartIsEmpty) {
        this.cartIsEmpty = cartIsEmpty;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void openCartPage() {
        this.driver.get("https://www.demoblaze.com/cart.html");
        this.driver.manage().window().maximize();
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td")));
    }

    public boolean checkIfCartIsEmpty() {
        if (getCartTableRowElements().size() > 1) {
            cartIsEmpty = false;
        } else {
            cartIsEmpty = true;
        }
        return cartIsEmpty;
    }

    public int sumOfPrices() {
        int toReturn = 0;
        int counter = 0;
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < getListOfBoughtItemsTable().size(); i++) {
            if (counter != 2) {
                toRemove.add(i);
                counter++;
            } else {
                counter = 0;
            }
        }
        for (int i = 0; i < toRemove.size(); i++) {
            getListOfBoughtItemsTable().remove(toRemove.get(i));
        }

        for (int i = 0; i < getListOfBoughtItemsTable().size(); i++) {
            toReturn = toReturn + Integer.parseInt(getListOfBoughtItemsTable().get(i).getText());
        }
        return toReturn;
    }

    public int sumOfPricesV2() {
        int toReturn = 0;
        for (int i = 1; i < getCartTableRowElements().size(); i++) {
            toReturn = toReturn + getCartTableRowPrice(i);
        }
        return toReturn;
    }
}
