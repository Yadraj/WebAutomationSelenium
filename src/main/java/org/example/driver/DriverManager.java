package org.example.driver;


import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {


    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public  static void init(){


        String browser = PropertyReader.readKey("browser");
        browser=browser.toLowerCase();
        if(browser!=null){
            switch (browser){

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver= new EdgeDriver();
                    break;

                default:
                    System.out.println("browser not found");
            }
        }




    }

    public  void down(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }


}
