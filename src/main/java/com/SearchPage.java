package com;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertEquals;


public class SearchPage extends BasePage{

    public SearchPage (WebDriver driver) {
        super (driver);
    }

    @FindBy (id ="Las Vegas")
    private WebElement result;

    By bySortDropdown=By.xpath("//div/select[@data-test-id='sortDropdown']");
    By byPriceIncreasing= By.xpath("//div/select/option[@data-opt-id='PRICE_INCREASING']");
    By byPriceDecreasing= By.xpath("//div/select/option[@data-opt-id='PRICE_DECREASING']");
    By byDepartureIncreasing= By.xpath("//div/select/option[@data-opt-id='DEPARTURE_INCREASING']");
    By byDepartureDecreasing= By.xpath("//div/select/option[@data-opt-id='DEPARTURE_DECREASING']");
    By byArrivalIncreasing= By.xpath("//div/select/option[@data-opt-id='ARRIVAL_INCREASING']");
    By byArrivalDecreasing= By.xpath("//div/select/option[@data-opt-id='ARRIVAL_DECREASING']");
    By byDurationIncreasing= By.xpath("//div/select/option[@data-opt-id='DURATION_INCREASING']");
    By byDurationDecreasing= By.xpath("//div/select/option[@data-opt-id='DURATION_DECREASING']");


    String priceLowest= "Price (Lowest)";
    String priceHighest= "Price (Highest)";
    String durationShortest= "Duration (Shortest)";
    String durationLongest= "Duration (Longest)";
    String departureEarliest= "Departure (Earliest)";
    String departureLatest= "Departure (Latest)";
    String arrivalEarliest= "Arrival (Earliest)";
    String arrivalLatest= "Arrival (Latest)";

    public void clickSortByDropdown() {
        boolean flag = true;
        long start = System.currentTimeMillis();
        while (flag) {
            try {
                ele = driver.findElement(bySortDropdown);
                if (ele.isEnabled()) {
                    moveToElement(ele);
                    ele.click();
                    flag = false;
                }
            } catch (NoSuchElementException e) {
            } catch (StaleElementReferenceException e) {
            } catch (Exception e) {
            }
            long actual = System.currentTimeMillis() - start;
            if (actual >= 10000L) {
                System.out.println("element not found");
                flag = false;
            }
        }
    }

    public boolean verifySortByPriceLowest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byPriceIncreasing));
        ele= driver.findElement(byPriceIncreasing);
        String sort= ele.getText();
        System.out.println("Verifying option displayed: " + sort);
        if (sort.equals(priceLowest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }

    public boolean verifySortByPriceHighest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byPriceDecreasing));
        ele= driver.findElement(byPriceDecreasing);
        String sort= ele.getText();
        System.out.println("Verifying option displayed: " + sort);
        if (sort.equals(priceHighest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }


    public boolean verifySortByDurationShortest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byDurationIncreasing));
        ele= driver.findElement(byDurationIncreasing);
        String sort= ele.getText();
        System.out.println("Verifying option displayed: " + sort);
        if (sort.equals(durationShortest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }

    public boolean verifySortByDurationLongest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byDurationDecreasing));
        ele= driver.findElement(byDurationDecreasing);
        String sort= ele.getText();
        System.out.println("Verifyng option displayed: " + sort);
        if (sort.equals(durationLongest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }


    public boolean verifySortByDepartureEarliest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byDepartureIncreasing));
        ele= driver.findElement(byDepartureIncreasing);
        String sort= ele.getText();
        System.out.println("Verifying option displayed: " + sort);
        if (sort.equals(departureEarliest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }

    public boolean verifySortByDepartureLatest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byDepartureDecreasing));
        ele= driver.findElement(byDepartureDecreasing);
        String sort= ele.getText();
        System.out.println("Verifying option displayed: " + sort);
        if (sort.equals(departureLatest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }

    public boolean verifySortByArrivalEarliest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byArrivalIncreasing));
        ele= driver.findElement(byArrivalIncreasing);
        String sort= ele.getText();
        System.out.println("Verifying option displayed: " + sort);
        if (sort.equals(arrivalEarliest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }

    public boolean verifySortByArrivalLatest(){
        getWait().until(ExpectedConditions.elementToBeClickable(byArrivalDecreasing));
        ele= driver.findElement(byArrivalDecreasing);
        String sort= ele.getText();
        System.out.println("Verifying option displayed: " + sort);
        if (sort.equals(arrivalLatest)){
            System.out.println("option displayed correctly");
            return true;        }
        else{
            System.out.println("option not match");
            return false;
        }
    }


}




