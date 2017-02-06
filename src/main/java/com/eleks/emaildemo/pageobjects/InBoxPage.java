package com.eleks.emaildemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andriy on 30.01.2017.
 */
public class InBoxPage extends BasicPage {

    By settings = By.xpath("html/body/div[1]/div[2]/div[1]/ul[3]/li[3]/span");
    // WebElement popUpSettings = driver.findElement(By.xpath(".//*[@id='accountSettingsPopup']"));
    By logOut = By.xpath("html/body/div[1]/div[2]/div[1]/div/ul/li[7]/a");
    By row = By.xpath("html/body/div[1]/div[5]/div[2]/div[2]/div[2]/form/div[1]/a/span[3]/span");
    By message = By.xpath("html/body/div[1]/div[5]/div[2]/div[2]/ul/li/div[1]/div/div[2]");

    public InBoxPage(WebDriver driver) {
        super(driver);
        // if (!driver.getTitle().equals("Вхідні - I.UA")) {
        //   throw new WrongPageException("Incorrect page for inbox");
        //}
    }

    public boolean isInBoxPageOpen() {
        return driver.getTitle().equals("Вхідні - I.UA ") ? true : false;
    }

    public MessagePage openMessage() {
        driver.findElement(row).click();
        return new MessagePage(driver);
    }

    public void isMessagePageOpen() {
        WebElement messageElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(message));
    }

    public LogInPage logOut() {
        driver.findElement(settings).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logOut)));
        driver.findElement(logOut).click();
        return new LogInPage(driver);
    }

}
