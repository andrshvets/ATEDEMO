package com.eleks.emaildemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andriy on 04.02.2017.
 */
public class MessagePage extends BasicPage {

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    By settings = By.xpath("html/body/div[1]/div[2]/div[1]/ul[3]/li[3]/span");
    By logOut = By.xpath("html/body/div[1]/div[2]/div[1]/div/ul/li[7]/a");
    By body = By.xpath("html/body/div[1]/div[5]/div[2]/div[2]/ul/li/div[1]/div/div[3]/pre");

    //public String actualTitle = driver.getTitle();
    //public String expectedTitle = "Обережно шахраї! - Вхідні - I.UA ";


    public LogInPage logOut() {
        driver.findElement(settings).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logOut)));
        driver.findElement(logOut).click();
        return new LogInPage(driver);
    }


    public boolean isBodyRight() {
        String bodyText = driver.findElement(body).getText();
        return bodyText.startsWith("Шановний користувач.") ? true : false;
    }
}
