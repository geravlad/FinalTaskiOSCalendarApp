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

public class SplashScreenPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "SplashScreen")
    protected RemoteWebElement splashScreenPageContainer;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    protected RemoteWebElement continueButton;

    public SplashScreenPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar landing page is loaded")
    public boolean calendarLandingPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(splashScreenPageContainer)).isDisplayed();
    }

    @Step("Click continue button")
    public void clickContinueButton() {
        continueButton.click();
    }
}
