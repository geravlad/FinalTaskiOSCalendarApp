package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.List;
import java.util.stream.IntStream;

import static java.time.Duration.ZERO;
import static java.time.Duration.ofSeconds;

import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class Helpers {

    public enum Directions {
        UP,
        DOWN
    }

    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public void swipeVertically(IOSDriver driver, Directions directions) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY;

        switch (directions) {
            case UP -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
            case DOWN -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
            default -> throw new IllegalArgumentException("Invalid direction selected" + directions);
        }

        Sequence swipe = new Sequence(FINGER, 0);
        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), startX, endY));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

//    @Step("Scroll to element")
//    public void scrollTo(IOSDriver driver, WebElement element, Directions directions, int swipeCount) {
//        IntStream.range(0, swipeCount).forEach(obj -> {
//            System.out.println("scroll");
//            if (!element.isDisplayed())
//                swipeVertically(driver, directions);
//        });
//    }

    @Step("Scroll to element")
    public void scrollTo(IOSDriver driver, Directions directions, int swipeCount) {
        IntStream.range(0, swipeCount).forEach(obj -> {
            swipeVertically(driver, directions);
        });
    }

    public Point getCenter(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
    }

    public void clickCoordinates(IOSDriver driver, int x, int y) {
        TouchAction touchAction = new TouchAction(driver);
        int xPoint = x;
        int yPoint = y;
        touchAction.tap(PointOption.point(xPoint , yPoint)).perform();
    }
}
