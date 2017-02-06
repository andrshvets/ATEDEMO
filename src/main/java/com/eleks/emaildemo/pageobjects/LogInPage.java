package com.eleks.emaildemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andriy on 30.01.2017.
 * Login PO
 */
public class LogInPage extends BasicPage {

    By login = By.name("login");
    By password = By.name("pass");
    By dropDownList = By.xpath("html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/ul/li[2]/p/select");
    By submit = By.xpath("html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/p/input");
    By makeMessage = By.xpath("html/body/div[1]/div[5]/div[1]/div[1]/p/a");
    By partners = By.cssSelector(".partner_links");

    //Constructor with verification

    public LogInPage(WebDriver driver) {
        super(driver);
        //if (!driver.getTitle().equals("І.UA - твоя пошта ")) {
        //    throw new WrongPageException("Incorrect page for log in");
        // }
    }

    public void open() {
        driver.navigate().to("http://i.ua");
    }

    public void isInLogInPage() {

        WebElement makeMessageElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(partners));
    }

    public void setUserName(String strUserName) {
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(strPassword);
    }

    public void setDomain() {
        Select select = new Select(driver.findElement(dropDownList));
        //select.deselectAll();
        select.selectByVisibleText("i.ua");

    }

    public void clickLogin() {
        driver.findElement(submit).click();
        //driver.findElement(By.xpath("html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/p/input")).click();
    }

    public void isInboxPage() {

        WebElement makeMessageElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(makeMessage));
        //Assert.assertEquals(driver.getTitle(), "Вхідні - I.UA ");
    }

    public InBoxPage logIn(String strUserName, String strPassword) {
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.setDomain();
        this.clickLogin();
        return new InBoxPage(driver);

    }

    public PassportPage unsuccessfulLogIn(String strUserName, String strWrongPassword) {
        this.setUserName(strUserName);
        this.setPassword(strWrongPassword);
        this.setDomain();
        this.clickLogin();
        return new PassportPage(driver);
    }
}
