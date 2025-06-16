package lib.core;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {

//    public static DesiredCapabilities getCapabilities() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Medium_Phone_API_36.0");
//        capabilities.setCapability("platformVersion", "16.0");
//        capabilities.setCapability("automationName", "uiautomator2");
//        capabilities.setCapability("appPackage", "org.wikipedia.alpha");
//        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
//        capabilities.setCapability("app", "C:\\Users\\user\\projects\\wikipedia_mobile\\src\\test\\resources\\apps\\app-alpha-universal-release.apk");
//
//        return capabilities;
//    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigManager.getPlatformName());
        capabilities.setCapability("deviceName", ConfigManager.getDeviceName());
        capabilities.setCapability("platformVersion", ConfigManager.getPlatformVersion());
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "org.wikipedia.alpha");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", ConfigManager.getAppPath());
        return capabilities;
    }
}
