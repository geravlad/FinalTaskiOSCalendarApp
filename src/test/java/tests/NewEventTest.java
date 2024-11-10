package tests;

import io.qameta.allure.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverSetup;
import utils.GlobalVariables;

@Epic("Mobile automation calendar app testing")
@Feature("Event")
public class NewEventTest extends DriverSetup {

    @Description("Test Description: Create a new event")
    @Story("Successful creation of a new calendar event")
    @Test(testName = "New event test")
    public void newEventTest() {

//        Assert.assertTrue(splashScreenPage.calendarLandingPageLoaded(), "Splash screen page is not loaded");

//        splashScreenPage.clickContinueButton();
        Assert.assertTrue(calendarLandingPage.calendarLandingPageLoaded(), "Calendar landing page is not loaded");

        calendarLandingPage.clickPlusButton();
        Assert.assertTrue(newEventPage.newEventPagePageLoaded(), "New event page is not loaded");

        GlobalVariables.response = restAssuredUtility.getActivityValue("activity");

        newEventPage.enterEventTitle(GlobalVariables.response);
        Assert.assertEquals(newEventPage.getEventTitleText(), GlobalVariables.response);

        newEventPage.clickStartsDateButton();

        newEventPage.chooseDay("24");

        newEventPage.chooseMonthAndYear("December", "2024");

        newEventPage.chooseHour("11", "10");

        newEventPage.clickEndsDateButton();

        newEventPage.chooseDay("25");

        newEventPage.chooseMonthAndYear("December", "2024");

        newEventPage.chooseHour("12", "25");

        newEventPage.chooseTravelTime();

        newEventPage.switchToAllDay();
        Assert.assertTrue(newEventPage.assertOnlyDatePickerIsDisplayed(), "Date and Time pickers are displayed");

        newEventPage.clickAddButton();
        Assert.assertTrue(calendarLandingPage.calendarLandingPageLoaded(), "Calendar landing page is not loaded");

        newEventPage.clickBackToMonthViewButton();
        Assert.assertTrue(monthsViewPage.monthViewPageLoaded(), "Months view page is not loaded");

        monthsViewPage.assertStartEventDate();

        monthsViewPage.assertEndEventDate();
    }


}
