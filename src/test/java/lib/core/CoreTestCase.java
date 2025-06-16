package lib.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lib.ui.factories.PageFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public abstract class CoreTestCase {

    protected AppiumDriver driver;
    protected PageFactory pages;


    @BeforeEach
    public void setUp() {
        try {
            initializeDriver();
            pages = new PageFactory(driver);
            pages.onboarding().skip();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize test environment: " + e.getMessage(), e);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void initializeDriver() throws Exception {
        Configuration.timeout = ConfigManager.getDefaultTimeout();

        DesiredCapabilities capabilities = CapabilitiesManager.getCapabilities();
        String appiumUrl = ConfigManager.getAppiumUrl();

        driver = new AndroidDriver(new URL(appiumUrl), capabilities);
        WebDriverRunner.setWebDriver(driver);

        System.out.println("Driver initialized with capabilities: " + capabilities);
    }
}
