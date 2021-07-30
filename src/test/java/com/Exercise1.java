package com;

import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    HomePage homePage;
    SearchPage searchPage;

    @Test
    public void testSearch() throws InterruptedException {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);

        homePage.selectFlight();
        homePage.selectRoundTrip();

        homePage.LeavingFrom("LAS");
        homePage.GoingTo2("LAX");
        homePage.Departing2();
        homePage.Returning2();
        homePage.clickSearch();

        searchPage.clickSortByDropdown();
        searchPage.verifySortByPriceLowest();
        searchPage.verifySortByPriceHighest();
        searchPage.verifySortByDurationShortest();
        searchPage.verifySortByDurationLongest();
        searchPage.verifySortByDepartureEarliest();
        searchPage.verifySortByDepartureLatest();
        searchPage.verifySortByArrivalEarliest();
        searchPage.verifySortByArrivalLatest();

    }
}
