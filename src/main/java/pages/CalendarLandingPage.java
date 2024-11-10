package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalVariables;

public class CalendarLandingPage{

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Calendar")
    protected RemoteWebElement calendarLandingPageContainer;

    @iOSXCUITFindBy(accessibility = "add-plus-button")
    protected RemoteWebElement plusButton;

    @iOSXCUITFindBy(accessibility = "calendars-button")
    protected RemoteWebElement calendarsButton;

    public CalendarLandingPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar landing page is loaded")
    public boolean calendarLandingPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarLandingPageContainer)).isDisplayed();
    }

    @Step("Click on plus button to create a new event")
    public void clickPlusButton() {
        plusButton.click();
    }

    @Step("Click calendars button")
    public void clickCalendarsButton() {
        calendarsButton.click();
    }
}
