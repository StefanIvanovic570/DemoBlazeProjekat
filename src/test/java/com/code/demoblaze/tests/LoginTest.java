package com.code.demoblaze.tests;

import com.code.demoblaze.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void verifyLogIn() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.getBtnLogIn().click();
        mainPage.waitBtnLogInWithCredentials();

        mainPage.inputUserName("test");
        mainPage.inputPassword("test");
        mainPage.getBtnLogInWithCredentials().click();

        mainPage.waitForLoading(2000);
        Assert.assertTrue(mainPage.getBtnLogOut().isDisplayed());
    }
}
