package lib.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import lib.ui.factories.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class NavigationPage extends BasePage {

    public NavigationPage(AppiumDriver driver, PageFactory factory) {
        super(driver, factory);
    }

    private final SelenideElement
            tabReadingList = $(id("org.wikipedia.alpha:id/nav_tab_reading_lists"));

    public NavigationPage selectSavedArticlesTab() {
        click(tabReadingList, "Cannot find saved button on main page options");
        return this;
    }
}
