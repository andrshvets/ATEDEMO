package com.eleks.emaildemo.tests;

import com.eleks.emaildemo.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Created by Andriy on 04.02.2017.
 */
public class BasicTest {
    public static WebDriver driver;
    LogInPage logInPage;
    InBoxPage inBoxPage;
    MessagePage messagePage;
    PassportPage passportPage;

    @Parameters({"browser"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String browser) throws Exception {
        driver = SingletonWD.getInstance(browser);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        SingletonWD.killInstance();
    }


}
