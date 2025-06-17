package lib.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import io.qameta.allure.Step;

public class RotationUtils {

    @Step("Переворачиваем экран в горизонтальный режим")
    public static void rotateScreenPortrait(AppiumDriver driver) {
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).rotate(ScreenOrientation.PORTRAIT);
        } else {
            throw new UnsupportedOperationException("Screen rotation is only supported on AndroidDriver");
        }
    }

    @Step("Переворачиваем экран в портретный режим")
    public static void rotateScreenLandscape(AppiumDriver driver) {
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).rotate(ScreenOrientation.LANDSCAPE);
        } else {
            throw new UnsupportedOperationException("Screen rotation is only supported on AndroidDriver");
        }
    }

}
