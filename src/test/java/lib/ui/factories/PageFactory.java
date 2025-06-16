package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.ui.pages.*;

public class PageFactory {

    private final AppiumDriver driver;

    public PageFactory(AppiumDriver driver) {
        this.driver = driver;
    }

    public OnboardingPage onboarding() {
        return new OnboardingPage(driver, this);
    }

    public SearchPage search() {
        return new SearchPage(driver, this);
    }

    public ArticlePage article() {
        return new ArticlePage(driver,this);
    }

    public MyListPage myList() {
        return new MyListPage(driver,this);
    }

    public NavigationPage navigation() {
        return new NavigationPage(driver,this);
    }
}
