package lib.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.selenide.AllureSelenide;
import lib.listeners.AllureEnvironmentWriter;
import lib.listeners.FailureListener;
import lib.ui.factories.PageFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.remote.DesiredCapabilities;

@ExtendWith(FailureListener.class)
public abstract class CoreTestCase {

    protected AppiumDriver driver;
    protected PageFactory pages;

    @BeforeEach
    public void setUp() {
        try {
            initializeDriver();
            AllureEnvironmentWriter.createEnvironmentFile();
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

        driver = DriverFactory.createDriver();
        WebDriverRunner.setWebDriver(driver);

        // ВАЖНО: Передаем driver в listener
        FailureListener.setDriver(driver);

        // Подключаем SelenideListener для Allure
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        System.out.println("Driver initialized: " + driver);
    }
}
