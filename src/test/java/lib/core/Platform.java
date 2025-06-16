package lib.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

//public class Platform {
//
//    private static final String PLATFORM_ANDROID = "android";
//    private static final String APPIUM_URL = "http://127.0.0.1:4723";
//
//    public boolean isAndroid() {
//        return isPlatform(PLATFORM_ANDROID);
//    }
//
//    public AppiumDriver getDriver() throws Exception {
//        URL URL = new URL(APPIUM_URL);
//        if (isAndroid()) {
//            return new AndroidDriver(URL, getAndroidDesiredCapabilities());
//        } else {
//            throw new Exception("Cannot detect type of the Driver. Platform value: " + getPlatformVar());
//        }
//    }
//
//    private DesiredCapabilities getAndroidDesiredCapabilities() {
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("platformName", ConfigManager.getPlatform());
//        capabilities.setCapability("deviceName", ConfigManager.getDeviceName());
//        capabilities.setCapability("platformVersion", ConfigManager.getPlatformVersion());
//        capabilities.setCapability("automationName", "uiautomator2");
//        capabilities.setCapability("appPackage", "org.wikipedia.alpha");
//        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
//        capabilities.setCapability("app", ConfigManager.getAppPath());
//        return capabilities;
//    }
//
//    private boolean isPlatform(String myPlatform) {
//        String platform = this.getPlatformVar();
//        return myPlatform.equals(platform);
//    }
//
//    private String getPlatformVar() {
//        return System.getenv("PLATFORM");
//    }
//}
