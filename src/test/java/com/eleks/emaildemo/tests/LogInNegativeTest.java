package com.eleks.emaildemo.tests;

import com.eleks.emaildemo.pageobjects.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Andriy on 04.02.2017.
 */
public class LogInNegativeTest extends BasicTest {


    @Test
    public void logInNegativeTest() throws Exception {
        logInPage = new LogInPage(driver);
        logInPage.open();
        Assert.assertEquals(driver.getTitle(), "І.UA - твоя пошта ");
        /*inBoxPage = */
        logInPage.logIn("Seleniumdemo", "");
        Assert.assertEquals(driver.getTitle(), "І.UA - твоя пошта ");
    }
}

