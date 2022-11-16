package com.code.demoblaze.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartTest extends TestMethods {
    @Test
    public void addToCart() {
        mainPage.openMainPage();
        mainPage.getBtnCart().click();
        Assert.assertTrue(cartPage.checkIfCartIsEmpty());

        addProduct("Nexus 6");
        addProduct("Dell i7 8gb");

        mainPage.getBtnCart().click();
        cartPage.waitCartContents();
        cartPage.checkIfCartIsEmpty();
        Assert.assertFalse(cartPage.getCartIsEmpty());
    }
}