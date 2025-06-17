package lib.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.ui.factories.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingPage extends BasePage {


    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    public OnboardingPage(AppiumDriver driver, PageFactory factory) {
        super(driver, factory);
    }

    @Step("Пропускаем экран приветствия (Onboarding)")
    public OnboardingPage skip() {
        click(skipButton,"Cannot click Skip button on Onboarding screen");
        return this;
    }
}
