package utils;

import org.testng.annotations.Listeners;

import pages.*;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import io.qameta.allure.Step;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Listeners(ITestListenerUtility.class)
public class DriverSetup extends ConfigReader{

    protected static IOSDriver driver;

    protected Helpers helpers;

    protected RestAssuredUtility restAssuredUtility;

    protected SplashScreenPage splashScreenPage;
    protected CalendarLandingPage calendarLandingPage;
    protected NewEventPage newEventPage;
    protected MonthsViewPage monthsViewPage;
    protected CalendarsPage calendarsPage;

    @Step("Driver started")
    @BeforeMethod
    public void setUP() {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(getProperty("device.name"))
                .setBundleId(getProperty("bundle.id"))
                .setPlatformVersion(getProperty("platform.version"))
                .setNoReset(false)
//                .setFullReset(true)
                .setCapability("autoDismissAlerts", true);

        try {
            driver = new IOSDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        helpers = new Helpers();

        restAssuredUtility = new RestAssuredUtility();

        splashScreenPage = new SplashScreenPage(driver);
        calendarLandingPage = new CalendarLandingPage(driver);
        newEventPage = new NewEventPage(driver);
        monthsViewPage = new MonthsViewPage(driver);
        calendarsPage = new CalendarsPage(driver);
    }

    @Step("Driver closed")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }


}
