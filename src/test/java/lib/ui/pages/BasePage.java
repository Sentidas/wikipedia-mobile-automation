package lib.ui.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumDriver;
import lib.ui.factories.PageFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class BasePage {

    protected final AppiumDriver driver;
    protected final PageFactory factory;

    public BasePage(AppiumDriver driver, PageFactory factory) {
        this.driver = driver;
        this.factory = factory;
    }

    protected void click(SelenideElement element, String errorMessage, Duration timeout) {
        element.shouldBe(visible.because(errorMessage), timeout).click();
    }

    protected void click(SelenideElement element, String errorMessage) {
        element.shouldBe(visible.because(errorMessage)).click();
    }

    protected void click(SelenideElement element, Duration timeout) {
        element.shouldBe(visible, timeout).click();
    }

    protected void click(SelenideElement element) {
        element.shouldBe().click();
    }

    protected void typeText(SelenideElement element, String text, String errorMessage, Duration timeout) {
        element.shouldBe(visible.because(errorMessage), timeout).sendKeys(text);
    }

    protected void typeText(SelenideElement element, String text, String errorMessage) {
        element.shouldBe(visible.because(errorMessage)).sendKeys(text);
    }

    protected void typeText(SelenideElement element, String text, Duration timeout) {
        element.shouldBe(visible, timeout).sendKeys(text);
    }

    protected void typeText(SelenideElement element, String text) {
        element.shouldBe(visible).sendKeys(text);
    }

    protected void shouldBeVisible(SelenideElement element, String errorMessage, Duration timeout) {
        element.shouldBe(visible.because(errorMessage), timeout);
    }

    protected void shouldBeVisible(SelenideElement element, String errorMessage) {
        element.shouldBe(visible.because(errorMessage));
    }


    protected void shouldBeVisible(SelenideElement element, Duration timeout) {
        element.shouldBe(visible, timeout);
    }

    protected void shouldBeVisible(SelenideElement element) {
        element.shouldBe(visible);
    }

    protected void shouldNotBeVisible(SelenideElement element, String errorMessage, Duration timeout) {
        element.shouldNotBe(visible.because(errorMessage), timeout);
    }

    protected void shouldNOtBeVisible(SelenideElement element, String errorMessage) {
        element.shouldNotBe(visible.because(errorMessage));
    }

    protected void checkResultsPresent(ElementsCollection results, Duration timeout) {
        results.shouldBe(CollectionCondition.sizeGreaterThan(0), timeout);
    }

    protected void checkResultsAbsent(ElementsCollection results, Duration timeout) {
        results.shouldBe(CollectionCondition.size(0), timeout);
    }
}

