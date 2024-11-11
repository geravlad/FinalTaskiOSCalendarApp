package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalVariables;

public class CalendarsPage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Calendars\"`]")
    protected RemoteWebElement calendarsNavigationBar;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Add Calendar\"`]")
    protected RemoteWebElement addCalendarNavigationBar;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Calendar Colour\"`]")
    protected RemoteWebElement calendarColorNavigationBar;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Edit Calendar\"`]")
    protected RemoteWebElement editCalendarNavigationBar;

    @iOSXCUITFindBy(accessibility = "add-calendar-button")
    protected RemoteWebElement addCalendarButton;

    @iOSXCUITFindBy(accessibility = "add-calendar-menubutton")
    protected RemoteWebElement addCalendarMenuButton;

    @iOSXCUITFindBy(accessibility = "calendar-title-field")
    protected RemoteWebElement calendarTitleField;

    @iOSXCUITFindBy(accessibility = "chevron")
    protected RemoteWebElement colorPickerButton;

    @iOSXCUITFindBy(accessibility = "Add Calendar")
    protected RemoteWebElement backToAddCalendarButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"done-button\"])[2]")
    protected RemoteWebElement doneButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
    protected RemoteWebElement defaultCalendar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]")
    protected RemoteWebElement newCalendar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"checkmark.circle.fill\"])[1]")
    protected RemoteWebElement defaultCalendarCheckmark;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"checkmark.circle.fill\"])[2]")
    protected RemoteWebElement newCalendarCheckmark;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"info.circle\"`][2]")
    protected RemoteWebElement infoCircle;

    @iOSXCUITFindBy(accessibility = "delete-calendar-button")
    protected RemoteWebElement deleteCalendarButton;

    @iOSXCUITFindBy(accessibility = "Delete Calendar")
    protected RemoteWebElement deleteCalendarPopUpButton;

    @iOSXCUITFindBy(accessibility = "done-button")
    protected RemoteWebElement doneButtonCalendarPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Are you sure you want to delete this calendar? All events associated with the calendar will also be deleted.\"`]")
    protected RemoteWebElement deleteCalendarPopUpTitle;

    public CalendarsPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendars page is loaded")
    public boolean calendarsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarsNavigationBar)).isDisplayed();
    }

    @Step("Add calendar")
    public void addCalendar() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarButton)).isDisplayed();
        addCalendarButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarMenuButton)).isDisplayed();
        addCalendarMenuButton.click();
    }

    @Step("Add calendar page is loaded")
    public boolean addCalendarPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarNavigationBar)).isDisplayed();
    }

    @Step("Enter calendar name")
    public void enterCalendarName(String name) {
        calendarTitleField.sendKeys(name);
    }

    @Step("Choose calendar color")
    public void chooseCalendarColor(String color) {
        colorPickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarColorNavigationBar)).isDisplayed();
        WebElement colorButton = driver.findElement(AppiumBy.accessibilityId(color));
        colorButton.click();
        backToAddCalendarButton.click();
    }

    @Step("Click done button")
    public void clickDoneButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addCalendarNavigationBar)).isDisplayed();
        doneButton.click();
    }

    @Step("Verify calendar was successfully created")
    public boolean assertNewCalendarDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newCalendar)).isDisplayed();
    }

    @Step("Verify default calendar is selected")
    public boolean assertDefaultCalendarCheckmarkDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(defaultCalendarCheckmark)).isDisplayed();
    }

    @Step("Verify new calendar is selected")
    public boolean assertNewCalendarCheckmarkDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newCalendarCheckmark)).isDisplayed();
    }

    @Step("Click on info circle")
    public void clickInfoCircle() {
        infoCircle.click();
    }

    @Step("Delete calendar")
    public void deleteCalendar() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(deleteCalendarButton)).isDisplayed();
        deleteCalendarButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(deleteCalendarPopUpTitle)).isDisplayed();
        clickCoordinates(driver, 190, 835);
    }

    @Step("Click done button on calendars page")
    public void clickDoneButtonCalendarPage() {
        doneButtonCalendarPage.click();
    }
}
