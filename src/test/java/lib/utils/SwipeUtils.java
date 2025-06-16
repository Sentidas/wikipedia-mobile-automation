package lib.utils;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

import static com.codeborne.selenide.Condition.visible;

public class SwipeUtils {


    public static void swipeUp(AppiumDriver driver, Duration duration) {
        // Создаем объект "палец" (устройство ввода)
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Получаем размер экрана устройства
        Dimension size = driver.manage().window().getSize();

        // Вычисляем координаты свайпа:
        int x = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        // Создаем последовательность действий (жест) с номером послед 0
        Sequence swipe = new Sequence(finger, 0);

        // Перемещаем палец в стартовую точку (без нажатия)
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
        // Нажимаем на экран
        swipe.addAction(finger.createPointerDown(0));
        // Двигаемся вверх в течение указанного времени
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), x, endY));
        // Отпускаем палец
        swipe.addAction(finger.createPointerUp(0));

        // Выполняем свайп
        driver.perform(Collections.singletonList(swipe));
    }


    public static void swipeUpFast(AppiumDriver driver) {
        swipeUp(driver, Duration.ofMillis(200));
    }

    public static void swipeUpToFindElement(AppiumDriver driver, SelenideElement locator, String errorMessage, int maxSwipes) {

        int swipesPerformed = 0;
        while (!locator.exists()) {
            if (swipesPerformed > maxSwipes) {
                locator.shouldBe(visible.because(errorMessage), Timeouts.SHORT);
                return;
            }
            swipeUpFast(driver);
            swipesPerformed++;
        }
    }

    public static void swipeElementToLeft(AppiumDriver driver, SelenideElement element) {

        int startX = element.getLocation().getX() + element.getSize().getWidth(); // правый край
        int endX = element.getLocation().getX(); // левый край
        int centerY = calculateElementCenterY(element);

        // Создаем объект "палец" (устройство ввода)
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Создаем последовательность действий (жест) с номером послед 0
        Sequence swipe = new Sequence(finger, 0);

        // Перемещаем палец в стартовую точку (без нажатия)
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
        // Нажимаем на экран
        swipe.addAction(finger.createPointerDown(0));
        // Двигаемся влево в течение указанного времени
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, centerY));
        // Отпускаем палец
        swipe.addAction(finger.createPointerUp(0));

        // Выполняем свайп
        driver.perform(Collections.singletonList(swipe));
    }

    public static void longTap(AppiumDriver driver, SelenideElement element) {

        int centerX = calculateElementCenterX(element);
        int centerY = calculateElementCenterY(element);

        // Создаем объект "палец" (устройство ввода)
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Создаем последовательность действий (жест) с номером послед 0
        Sequence longPress = new Sequence(finger, 0);

        // Перемещаем палец в стартовую точку (без нажатия)
        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
        // Нажимаем на экран
        longPress.addAction(finger.createPointerDown(0));

        longPress.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, centerY));


        // Отпускаем палец
        longPress.addAction(finger.createPointerUp(0));

        driver.perform(Collections.singletonList(longPress));
    }

    private static int calculateElementCenterX(SelenideElement element) {
        return element.getLocation().getX() + element.getSize().getWidth() / 2;
    }

    private static int calculateElementCenterY(SelenideElement element) {
        return element.getLocation().getY() + element.getSize().getHeight() / 2;
    }
}
