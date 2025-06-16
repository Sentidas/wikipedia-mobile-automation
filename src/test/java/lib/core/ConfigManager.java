package lib.core;

import java.io.File;
import java.nio.file.Paths;

public class ConfigManager {

    public static String getAppiumUrl() {
        return System.getProperty("appiumUrl", "http://127.0.0.1:4723");
    }

    public static String getPlatform() {
        return System.getProperty("platform", "android");
    }

    public static String getDeviceName() {
        return System.getProperty("deviceName", "Medium_Phone_API_36.0");
    }

    public static String getPlatformVersion() {
        return System.getProperty("platformVersion", "16.0");
    }

    public static String getAppPath() {
        return Paths.get(
                new File(".").getAbsolutePath(),
                "src", "test", "resources", "apps", "app-alpha-universal-release.apk"
        ).toString();
    }

    public static int getDefaultTimeout() {
        return 5000;
    }
}
