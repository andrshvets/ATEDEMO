package com.eleks.emaildemo.tests;

import com.eleks.emaildemo.pageobjects.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Andriy on 04.02.2017.
 */
public class LogInWrongPasswordTest extends BasicTest {


    @Test
    public void logInWithWorngPasswordTest() throws Exception {
        logInPage = new LogInPage(driver);
        logInPage.open();
        Assert.assertEquals(driver.getTitle(), "І.UA - твоя пошта ");
        passportPage = logInPage.unsuccessfulLogIn("Seleniumdemo", "wrongpass");
        passportPage.isOnPassportPage();
        Assert.assertEquals(driver.getTitle(), "Паспорт - I.UA ");
        logInPage.open();

    }

}
