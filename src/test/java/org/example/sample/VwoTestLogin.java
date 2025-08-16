package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VwoTestLogin {


    @Test
    public void vwoTestLogin() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("yadraj@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("123");
        driver.findElement(By.id("js-login-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement text = driver.findElement(By.id("js-notification-box-msg"));
        wait.until(ExpectedConditions.visibilityOf(text));
        String text1 =text.getText();
        Assert.assertEquals(text1,"Your email, password, IP address or location did not match");
        driver.quit();

    }
}
