package lib.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;

public class RotationUtils {

    public static void rotateScreenPortrait(AppiumDriver driver) {
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).rotate(ScreenOrientation.PORTRAIT);
        } else {
            throw new UnsupportedOperationException("Screen rotation is only supported on AndroidDriver");
        }
    }

    public static void rotateScreenLandscape(AppiumDriver driver) {
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).rotate(ScreenOrientation.LANDSCAPE);
        } else {
            throw new UnsupportedOperationException("Screen rotation is only supported on AndroidDriver");
        }
    }

}
