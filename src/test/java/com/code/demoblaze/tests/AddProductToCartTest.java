package com.code.demoblaze.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartTest extends TestMethods {
    @Test
    public void addToCart() throws InterruptedException {
        mainPage.openMainPage();
        mainPage.getBtnCart().click();
        Assert.assertTrue(cartPage.checkIfCartIsEmpty());

        addProductByName("Nexus 6");
        addProductByName("ASUS Full HD");

        mainPage.getBtnCart().click();
        cartPage.waitCartContents();
        cartPage.checkIfCartIsEmpty();
        Assert.assertFalse(cartPage.getCartIsEmpty());
    }
}