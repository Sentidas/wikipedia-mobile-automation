package lib.listeners;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.*;

@ExtendWith(AllureJunit5.class)
public class FailureListener implements TestExecutionExceptionHandler {

    private static AppiumDriver driver;

    public static void setDriver(AppiumDriver d) {
        driver = d;
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (driver != null) {
            AllureAttachments attachments = new AllureAttachments(driver);
            attachments.takeScreenshot();
            attachments.savePageSource();
        }
        throw throwable;
    }
}