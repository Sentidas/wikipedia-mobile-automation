package lib.core;

public class ConfigManager {

    public static String getAppiumUrl() {
        return System.getProperty("appiumUrl", "http://127.0.0.1:4723");
    }

    public static String getPlatformName() {
        return System.getProperty("platformName", "Android");
    }

    public static String getDeviceName() {
        return System.getProperty("deviceName", "Medium_Phone_API_36.0");
    }

    public static String getPlatformVersion() {
        return System.getProperty("platformVersion", "16.0");
    }

    public static String getAppPath() {
        return System.getProperty("appPath",
                "C:\\Users\\user\\projects\\wikipedia_mobile\\src\\test\\resources\\apps\\app-alpha-universal-release.apk");
    }

    public static int getDefaultTimeout() {
        return 5000;
    }
}
