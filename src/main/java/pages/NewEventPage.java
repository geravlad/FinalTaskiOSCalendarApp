package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalVariables;

public class NewEventPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"New\"`]")
    private RemoteWebElement newEventPageContainer;

    @iOSXCUITFindBy(accessibility = "Title")
    protected RemoteWebElement eventTitleField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Starts\"]/preceding-sibling::XCUIElementTypeButton/XCUIElementTypeButton)[1]")
    private RemoteWebElement startsDatePickerButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Date and Time Picker\"]/XCUIElementTypeButton[2]")
    private RemoteWebElement startsHourPickerButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Ends\"]/preceding-sibling::XCUIElementTypeButton/XCUIElementTypeButton)[1]")
    private RemoteWebElement endsDatePickerButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Date and Time Picker\"]/XCUIElementTypeButton[2]")
    private RemoteWebElement endsHourPickerButton;

    @iOSXCUITFindBy(className = "XCUIElementTypeCollectionView")
    private RemoteWebElement CollectionViewContainer;

    @iOSXCUITFindBy(accessibility = "DatePicker.Show")
    private RemoteWebElement datePickerShowButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement firstPickerWheel;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement secondPickerWheel;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"Travel Time\"`]")
    private RemoteWebElement travelTimePickerButton;

    @iOSXCUITFindBy(accessibility = "30 minutes")
    private RemoteWebElement thirtyMinutesButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`name == \"All-day\"`]")
    private RemoteWebElement allDaySwitch;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Date Picker\"`][1]")
    private RemoteWebElement onlyDatePickerButton;

    @iOSXCUITFindBy(accessibility = "add-button")
    private RemoteWebElement addButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"DayViewContainerView\"]/XCUIElementTypeButton)[1]")
    private RemoteWebElement backToMonthViewButton;


    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New event page is loaded")
    public boolean newEventPagePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventPageContainer)).isDisplayed();
    }

    @Step("Enter event title")
    public void enterEventTitle(String text) {
        eventTitleField.sendKeys(text);
    }

    @Step("Get text from title field")
    public String getEventTitleText() {
        return eventTitleField.getText();
    }

    @Step("Click on starts date button")
    public void clickStartsDateButton() {
        startsDatePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(CollectionViewContainer)).isDisplayed();
    }

    @Step("Choose start day")
    public void chooseDay(String day) {
        driver.findElement(AppiumBy.xpath(String.format("//XCUIElementTypeButton//XCUIElementTypeStaticText[@name=\"%s\"]", day))).click();
    }

    @Step("Month {0} and year {1} is chosen")
    public void chooseMonthAndYear(String month, String year) {
        datePickerShowButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(firstPickerWheel)).sendKeys(month);
        secondPickerWheel.sendKeys(year);
    }

    @Step("Hour {0} and minute {1} is chosen")
    public void chooseHour(String hour, String minutes) {
        startsHourPickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(firstPickerWheel)).sendKeys(hour);
        secondPickerWheel.sendKeys(minutes);
    }

    @Step("Click on ends date button")
    public void clickEndsDateButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(endsDatePickerButton)).isDisplayed();
        endsDatePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(CollectionViewContainer)).isDisplayed();
    }

    @Step("Travel time {0} is chosen")
    public void chooseTravelTime() {
        travelTimePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(CollectionViewContainer)).isDisplayed();
        thirtyMinutesButton.click();
    }

    @Step("Switch to All Day view")
    public void switchToAllDay() {
        allDaySwitch.click();
    }

    @Step("Assert only date picker is displayed")
    public boolean assertOnlyDatePickerIsDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(onlyDatePickerButton)).isDisplayed();
    }

    @Step("Add event")
    public void clickAddButton() {
        addButton.click();
    }

    @Step("Switch to month view")
    public void clickBackToMonthViewButton() {
        backToMonthViewButton.click();
    }


}
