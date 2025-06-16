package lib.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    public static AppiumDriver createDriver() throws Exception {
        String platform = ConfigManager.getPlatform().toLowerCase();

        switch (platform) {
            case "android":
                return createAndroidDriver();
            default:
                throw new Exception("Unknown platform: " + platform);
        }
    }

    private static AppiumDriver createAndroidDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", ConfigManager.getPlatform());
        capabilities.setCapability("deviceName", ConfigManager.getDeviceName());
        capabilities.setCapability("platformVersion", ConfigManager.getPlatformVersion());
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "org.wikipedia.alpha");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", ConfigManager.getAppPath());

        return new AndroidDriver(new URL(ConfigManager.getAppiumUrl()), capabilities);
    }
}
