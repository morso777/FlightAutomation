package com;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver) {
        super (driver);

}



    @FindBy(xpath = "//a[@href='?pwaLob=wizard-flight-pwa']")
    private WebElement flightsButton;

    @FindBy(xpath = "//a[@href='?flightType=roundtrip']")
    private WebElement roundTripButton;

    @FindBy(xpath = "//a[@href='?flightType=roundtrip']")
    private WebElement calendarButton;

    @FindBy(id = "d1-btn")
    private WebElement departing;

    @FindBy(id = "d2-btn")
    private WebElement returning;

    @FindBy(xpath= "//button[@aria-label= 'Leaving from']")
    private WebElement leavingFrom;

    @FindBy(xpath= "//*[contains(text(), 'Las Vegas (LAS - McCarran Intl.)')]")
    private WebElement las;

    @FindBy(xpath= "//*[contains(text(), 'Los Angeles (LAX - Los Angeles Intl.)')]")
    private WebElement lax;

    @FindBy(xpath= "//ul/li[@data-index='0']")
    private WebElement LAX;

    @FindBy(xpath= "//div[@class= 'uitk-typeahead-button-label uitk-type-medium uitk-type-300 truncate']")
    private WebElement losAngeles;

    //By.xpath("//div[@class= 'uitk-typeahead-button-label uitk-type-medium uitk-type-300 truncate']"

    @FindBy(xpath= "//button[@aria-label= 'Going to']")
    private WebElement goingTo;

    @FindBy(xpath= "//button[@data-stid= 'apply-date-picker']")
    private WebElement doneButton;

    @FindBy (xpath= "//*[@type= 'submit']")
    private WebElement searchButton;

    @FindBy (xpath= "//div/input[@name='fromDate']")
    private WebElement fromDatedate;

    @FindBy (xpath= "//div/input[@name='fromDate']")
    private WebElement toDate;

    @FindBy (xpath= "//td/button[@data-day='25']")
    private WebElement departingDay;

    @FindBy (xpath= "//td/button[@data-day='28']")
    private WebElement returningDay;

    @FindBy (xpath= "//div/button[2][@data-stid='date-picker-paging']")
    private WebElement clickNextMonth;




    public void iframe(){
        int size =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total frames in page= "+size );
        List<WebElement> nameIframes=driver.findElements(By.tagName("iframe"));
        for(int i=0; i< nameIframes.size();  i++) {
            System.out.println(nameIframes.get(i).getText());;
        }
        //System.out.println(nameIframes);
        //driver.switchTo().frame("booking-iframe-id");
    }

    public ArrayList<String> iframe2() throws InterruptedException {
        int size =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total frames in page= "+size );

        List<WebElement> nameIframes=driver.findElements(By.tagName("iframe"));

        ArrayList<String> iframe = new ArrayList<>();

        for(int i=0; i< nameIframes.size();  i++) {
            Thread.sleep(1000);
            String iframeName =nameIframes.get(i).getText();
            iframe.add(iframeName);
        }return(iframe);

    }


    public void selectFlight () {
        getWait().until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
    }

    public void selectRoundTrip() {
        getWait().until(ExpectedConditions.elementToBeClickable(roundTripButton));
        roundTripButton.click();
    }

    public void LeavingFrom(String Leaving) throws InterruptedException {
        getWait().until(ExpectedConditions.elementToBeClickable(leavingFrom));
        leavingFrom.sendKeys(Leaving);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Las Vegas (LAS - McCarran Intl.)')]")));
        las.click();
        //leavingFrom.submit();
    }

    public void GoingTo(String Going) throws InterruptedException {

        getWait().until(ExpectedConditions.elementToBeClickable(goingTo));
        goingTo.sendKeys(Going);

        boolean flag = true;
        long start = System.currentTimeMillis();
        while (flag) {
            try {
                ele = driver.findElement(By.xpath("//*[contains(text(), 'Los Angeles (LAX - Los Angeles Intl.)')]"));
                //if (ele.isDisplayed()) {
                if (ele.isDisplayed()) {
                    moveToElement(ele);
                    ele.click();
                    flag = false;
                }
            } catch (NoSuchElementException e) {
            } catch (StaleElementReferenceException e) {
            } catch (TimeoutException e) {
            } catch (Exception e) {
            }long actual = System.currentTimeMillis() - start;
            if (actual >= 10000L) {
                System.out.println("element not found ");
                flag = false;
            }

        }
    }

    public void GoingTo2(String Going) throws InterruptedException {

        getWait().until(ExpectedConditions.elementToBeClickable(goingTo));
        goingTo.sendKeys(Going);
        Thread.sleep(3000);
        //getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Los Angeles (LAX - Los Angeles Intl.)')]")));
        //getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[@data-index='0']")));
        //getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@data-index='0']")));
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Los Angeles (LAX - Los Angeles Intl.)')]")));
        moveToElement(lax);
        lax.click();
        //moveToElement(LAX);
        //LAX.click();
        //goingTo.submit();
    }



    // metodo seleccionar fecha

    public void Departing(String date) {
       // WebDriverWait wait = new WebDriverWait(driver,30);
        getWait().until(ExpectedConditions.elementToBeClickable(departing));
        departing.click();
        departingDay.click();
        //departing.sendKeys(date);

    }

    public void Departing2() {
        getWait().until(ExpectedConditions.elementToBeClickable(departing));
        departing.click();
        getWait().until(ExpectedConditions.elementToBeClickable(clickNextMonth));
        clickNextMonth.click();
        getWait().until(ExpectedConditions.elementToBeClickable(departingDay));
        departingDay.click();
        getWait().until(ExpectedConditions.elementToBeClickable(doneButton));
        doneButton.click();

    }

    public void Returning(String date) {
        getWait().until(ExpectedConditions.elementToBeClickable( returning));
        returning.click();
        //returning.sendKeys(date);
        //getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        //doneButton.click();
    }

    public void Returning2() {
        getWait().until(ExpectedConditions.elementToBeClickable( returning));
        returning.click();
        getWait().until(ExpectedConditions.elementToBeClickable(clickNextMonth));
        clickNextMonth.click();
        getWait().until(ExpectedConditions.elementToBeClickable(returningDay));
        returningDay.click();
        getWait().until(ExpectedConditions.elementToBeClickable(doneButton));
        doneButton.click();
    }

    public void clickSearch() {
        getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    //method select resultado busqueda

}
