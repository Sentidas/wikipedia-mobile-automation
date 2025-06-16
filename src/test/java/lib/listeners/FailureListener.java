package lib.listeners;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.*;

@ExtendWith(AllureJunit5.class)
public class FailureListener implements TestWatcher {

    private static AppiumDriver driver;

    public static void setDriver(AppiumDriver d) {
        driver = d;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (driver != null) {
            AllureAttachments attachments = new AllureAttachments(driver);
            attachments.takeScreenshot();
            attachments.savePageSource();
        }
    }
}
