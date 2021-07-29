package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    JavascriptExecutor jse2;

    //private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver driver;
    //public WebDriverWait wait;

    public BasePage (WebDriver pDriver) {
        PageFactory.initElements( pDriver, this);
        wait = new WebDriverWait (pDriver, 10);
        driver = pDriver;
    }


    public WebDriverWait getWait() {
        return wait;
    }

    protected WebDriver getDriver() {
        return driver;
    }


    public void dispose() {
        if (driver != null)	{
            driver.quit();
        }
    }


    WebElement ele;

    public void moveToElement(WebElement element){
        jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
    }
}
