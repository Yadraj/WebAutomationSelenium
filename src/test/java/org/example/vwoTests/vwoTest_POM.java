package org.example.vwoTests;

import org.example.base.CommonToAllTests;
import org.example.driver.DriverManager;
import org.example.pages.pageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class vwoTest_POM extends CommonToAllTests {



    @Test
    public  void negativeTestCase(){

        LoginPage_POM loginPage_pom = new LoginPage_POM(DriverManager.getDriver());
        String error1 = loginPage_pom.loginTestCase(PropertyReader.readKey("username"),PropertyReader.readKey("password"));
        Assert.assertEquals(error1,PropertyReader.readKey("error_message"));

    }


}
