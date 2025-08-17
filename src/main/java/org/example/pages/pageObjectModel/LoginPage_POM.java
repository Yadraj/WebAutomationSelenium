package org.example.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage_POM {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver) {

        this.driver=driver;
    }





    private By userName = By.id("login-username");
    private By password = By.id("login-password");
    private By signIn = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    public  String loginTestCase(String username, String pass){

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(userName).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signIn).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement text = driver.findElement(error_message);
        wait.until(ExpectedConditions.visibilityOf(text));
        String error =text.getText();
        return error;


    }






}
