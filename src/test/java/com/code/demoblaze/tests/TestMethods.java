package com.code.demoblaze.tests;

public class TestMethods extends BaseTest {
    public void addProductByName(String productName) {
        mainPage.getBtnHome().click();
        mainPage.clickOnProductByName(productName);
        productPage.waitBtnAddToCart();
        productPage.getBtnAddToCart().click();
        productPage.handleAlert();
    }
}
