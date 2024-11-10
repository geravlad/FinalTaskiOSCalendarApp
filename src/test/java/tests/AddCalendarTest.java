package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverSetup;

@Epic("Mobile automation calendar app testing")
@Feature("Event")
public class AddCalendarTest extends DriverSetup {

    @Description("Test Description: Add calendar")
    @Story("Successfully adding a new calendar")
    @Test(testName = "Add calendar test")
    public void addCalendarTest() {

//        Assert.assertTrue(splashScreenPage.calendarLandingPageLoaded(), "Splash screen page is not loaded");

//        splashScreenPage.clickContinueButton();

        Assert.assertTrue(calendarLandingPage.calendarLandingPageLoaded(), "Calendar landing page is not loaded");

        calendarLandingPage.clickCalendarsButton();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page is not loaded");

        calendarsPage.addCalendar();
        Assert.assertTrue(calendarsPage.addCalendarPageLoaded(), "Add calendar page is not loaded");

        calendarsPage.enterCalendarName("My Calendar");

        calendarsPage.chooseCalendarColor("Blue");

        calendarsPage.clickDoneButton();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page is not loaded");

        Assert.assertTrue(calendarsPage.assertNewCalendarDisplayed(), "New calendar is not displayed");

        Assert.assertTrue(calendarsPage.assertDefaultCalendarCheckmarkDisplayed(), "Default calendar is not selected");

        Assert.assertTrue(calendarsPage.assertNewCalendarCheckmarkDisplayed(), "New calendar is not selected");

        calendarsPage.clickInfoCircle();

        calendarsPage.deleteCalendar();

        Assert.assertTrue(calendarsPage.assertNewCalendarDisplayed(), "Deleted calendar displayed");

        calendarsPage.clickDoneButtonCalendarPage();

        Assert.assertTrue(calendarLandingPage.calendarLandingPageLoaded(), "Calendar landing page is not loaded");
    }

}
