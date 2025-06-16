package lib.listeners;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachments {
    private final AppiumDriver driver;

    public AllureAttachments(AppiumDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "Page Source", type = "text/plain")
    public String savePageSource() {
        return driver.getPageSource();
    }
}
