package com.code.demoblaze.tests;

import com.code.demoblaze.pages.CartPage;
import com.code.demoblaze.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartTest extends BaseTest {
    @Test
    public void addToCart() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        cartPage.openCartPage();
        Assert.assertTrue(cartPage.checkIfCartIsEmpty());

        mainPage.openMainPage();
        mainPage.addItemToCartByName("Nexus 6");

        cartPage.openCartPage();
        cartPage.waitCartContents();
        cartPage.checkIfCartIsEmpty();
        Assert.assertFalse(cartPage.getCartIsEmpty());
    }
}