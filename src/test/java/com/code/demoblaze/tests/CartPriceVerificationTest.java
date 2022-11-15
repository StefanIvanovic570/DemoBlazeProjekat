package com.code.demoblaze.tests;

import com.code.demoblaze.pages.CartPage;
import com.code.demoblaze.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPriceVerificationTest extends BaseTest {
    @Test
    public void verifyCartTotalPrice() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.addItemToCartByName("Nexus 6");

        mainPage.openMainPage();
        mainPage.addItemToCartByName("Dell i7 8gb");

        CartPage cartPage = new CartPage(driver);
        cartPage.openCartPage();

        mainPage.waitForLoading(4000);
        Assert.assertEquals(cartPage.sumOfPricesV2(), Integer.parseInt(cartPage.getTotalPriceElement().getText()));
    }
}
