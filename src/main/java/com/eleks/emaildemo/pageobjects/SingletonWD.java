package com.eleks.emaildemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andriy on 30.01.2017.
 * Singleton WD class
 */
public class SingletonWD {

    //private static final String CHROME = "chrome";
    // private static final String FIREFOX = "firefox";
    //private static final String IE = "ie";

    private static WebDriver driver;


    //getInstance of the WD

    public static WebDriver getInstance(String browser) {
        if (driver == null) {
            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equals("ie")) {
                System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else {
                throw new UnsupportedOperationException("Unknown browser " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void killInstance() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

