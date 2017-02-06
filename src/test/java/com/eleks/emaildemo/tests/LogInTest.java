package com.eleks.emaildemo.tests;

import com.eleks.emaildemo.pageobjects.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Andriy on 31.01.2017.
 */
public class LogInTest extends BasicTest {



    @Parameters({"password"})
    @Test
    public void logInTest(String password) throws Exception {
        logInPage = new LogInPage(driver);
        logInPage.open();
        Assert.assertEquals(driver.getTitle(), "І.UA - твоя пошта ");
        inBoxPage = logInPage.logIn("Seleniumdemo", password);
        logInPage.isInboxPage();
        Assert.assertEquals(driver.getTitle(), "Вхідні - I.UA ");
        Assert.assertTrue(inBoxPage.isInBoxPageOpen());
        logInPage = inBoxPage.logOut();
        logInPage.isInLogInPage();
        Assert.assertEquals(driver.getTitle(), "І.UA - твоя пошта ");
    }
}
