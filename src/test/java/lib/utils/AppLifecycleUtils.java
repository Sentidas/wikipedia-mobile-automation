package lib.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import java.time.Duration;

public class AppLifecycleUtils {

    @Step("Сворачиваем приложение на {seconds} секунд")
    public static void runAppInBackground(AppiumDriver driver, int seconds) {
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            throw new UnsupportedOperationException("Backgrounding only supported on AndroidDriver");
        }
    }
}
