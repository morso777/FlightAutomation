package com;

import com.beust.jcommander.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Properties;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    // que abra la pagina

    public String projectPath = System.getProperty("user.dir");
    public String url;
    String os = System.getProperty("os.name");

    //public Properties testdata = SystemUtil.loadPropertiesResources("testdata.properties");

    public WebDriver driver;

   @BeforeTest
    public void setUp() {
       System.setProperty("webdriver.chrome.driver", projectPath + "\\lib\\chromedriver\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("https://www.travelocity.com/");
       driver.manage().window().maximize();
   }



    //@AfterTest
    public void cleanSession() {
        //driver.quit();
        driver.close();
    }


    /*@BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeMethod(String browser) throws Exception {
        selectBrowser("chrome");
        driver.get("https://www.travelocity.com/");
        driver.manage().window().maximize();
    }


    private void selectBrowser(String browser) throws Exception {
        System.out.println(os);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions op = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", projectPath + "\\lib\\chromedriver.exe");
            driver = new ChromeDriver(op);
        } else if (browser.equalsIgnoreCase("firefox")) {
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    */


    protected WebDriver getDriver() {
        return driver;
    }
}




