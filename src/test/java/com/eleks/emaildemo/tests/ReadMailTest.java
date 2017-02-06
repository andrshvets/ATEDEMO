package com.eleks.emaildemo.tests;

import com.eleks.emaildemo.pageobjects.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Andriy on 04.02.2017.
 */
public class ReadMailTest extends BasicTest {

    @Parameters({"password"})
    @Test
    public void readMailTest(String password) {
        logInPage = new LogInPage(driver);
        logInPage.open();
        inBoxPage = logInPage.logIn("Seleniumdemo", password);
        logInPage.isInboxPage();
        messagePage = inBoxPage.openMessage();
        inBoxPage.isMessagePageOpen();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Обережно шахраї! - Вхідні - I.UA ";
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertTrue(messagePage.isBodyRight());
        logInPage = messagePage.logOut();
    }
}
