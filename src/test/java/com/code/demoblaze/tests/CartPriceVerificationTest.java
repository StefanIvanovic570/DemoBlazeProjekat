package com.code.demoblaze.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CartPriceVerificationTest extends BaseTest {
    @Test
    public void verifyCartTotalPrice() {
        mainPage.openMainPage();

        addProduct("Nexus 6");
        addProduct("Dell i7 8gb");

        mainPage.getBtnCart().click();
        cartPage.waitCartContents();

        Assert.assertEquals(cartPage.sumOfPricesV2(), Integer.parseInt(cartPage.getTotalPriceElement().getText()));
    }

    public void addProduct(String productName) {
        mainPage.getBtnHome().click();
        mainPage.clickOnProductByName(productName);
        productPage.waitBtnAddToCart();
        productPage.getBtnAddToCart().click();
        productPage.handleAlert();
    }
}
