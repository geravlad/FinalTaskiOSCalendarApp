package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import utils.GlobalVariables;
import utils.Helpers;

public class MonthsViewPage extends Helpers {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Months")
    protected RemoteWebElement monthsViewPageContainer;

    @iOSXCUITFindBy(accessibility = "Tuesday, 24 December")
    protected RemoteWebElement startEventDay;

    @iOSXCUITFindBy(accessibility = "Wednesday, 25 December")
    protected RemoteWebElement endEventDay;

    public MonthsViewPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Months view page is loaded")
    public boolean monthViewPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(monthsViewPageContainer)).isDisplayed();
    }

//    @Step("Verifying event day: {0}")
//    public void assertEventDate(String date) {
//        WebElement element = driver.findElement(AppiumBy.xpath(date));
//        scrollTo(driver, element, Directions.UP, 2);
//        String eventValue = element.getAttribute("value");
//        System.out.println(eventValue);
//    }

    @Step("Verifying starts event day")
    public void assertStartEventDate() {
        scrollTo(driver, Directions.UP, 2);
        String eventValue = startEventDay.getAttribute("value");
        Assert.assertNotEquals("No events", eventValue);
    }

    @Step("Verifying end event day")
    public void assertEndEventDate() {
        String eventValue = endEventDay.getAttribute("value");
        Assert.assertNotEquals("No events", eventValue);
    }
}
