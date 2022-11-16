package com.code.demoblaze.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void verifyLogIn() {
        mainPage.openMainPage();

        mainPage.getBtnLogIn().click();
        mainPage.waitBtnLogInWithCredentials();

        mainPage.inputUserName("test");
        mainPage.inputPassword("test");
        mainPage.getBtnLogInWithCredentials().click();

        mainPage.waitBtnLogOut();
        Assert.assertTrue(mainPage.getBtnLogOut().isDisplayed());
    }
}
