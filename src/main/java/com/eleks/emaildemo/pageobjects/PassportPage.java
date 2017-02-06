package com.eleks.emaildemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andriy on 04.02.2017.
 */
public class PassportPage extends BasicPage {

    By wrongLoginORPassword = By.cssSelector(".content");

    public PassportPage(WebDriver driver) {
        super(driver);
    }

    public void isOnPassportPage() {
        WebElement makeMessageElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(wrongLoginORPassword));
    }


}
