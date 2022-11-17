package com.code.demoblaze.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CartPriceVerificationTest extends TestMethods {
    @Test
    public void verifyCartTotalPrice() {
        mainPage.openMainPage();

        addProductByName("Nexus 6");
        addProductByName("ASUS Full HD");

        mainPage.getBtnCart().click();
        cartPage.waitCartContents();

        Assert.assertEquals(cartPage.sumOfPricesV2(), Integer.parseInt(cartPage.getTotalPriceElement().getText()));
    }


}
