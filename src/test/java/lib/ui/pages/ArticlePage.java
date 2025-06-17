package lib.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.ui.factories.PageFactory;
import lib.utils.SwipeUtils;
import lib.utils.Timeouts;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

public class ArticlePage extends BasePage {

    private final SelenideElement
            popup = $(id("org.wikipedia.alpha:id/container")),
            popupButtonSkip = $(id("org.wikipedia.alpha:id/closeButton")),
            footerElement = $(androidUIAutomator("new UiSelector().description(\"View article in browser\")")),
            saveButton = $(id("org.wikipedia.alpha:id/page_save")),
            snackBarActionButton = $(id("org.wikipedia.alpha:id/snackbar_action")),
            inputNameOfFolder = $(id("org.wikipedia.alpha:id/text_input")),
            saveButtonNameOfFolder = $(id("android:id/button1")),
            goToMyListInSnackbar = $(id("org.wikipedia.alpha:id/snackbar_action")),
            navigateUp = $(androidUIAutomator("new UiSelector().description(\"Navigate up\")"));


    public ArticlePage(AppiumDriver driver, PageFactory factory) {
        super(driver, factory);
    }

    /* TEMPLATES METHODS */
    private SelenideElement getTextElementInArticle(String text) {
        return $(androidUIAutomator("new UiSelector().text(\"" + text + "\")"));
    }
    /* TEMPLATES METHODS */

    @Step("Проверяем, что заголовок статьи соответствует '{expectedText}'")
    public ArticlePage checkTextInArticle(String text) {

        SelenideElement openedArticleTitle = getTextElementInArticle(text);
        shouldBeVisible(openedArticleTitle, "Cannot find text in article: " + text, Timeouts.LONG);

        String articleTitle = openedArticleTitle.text();

        System.out.println("Article title: " + articleTitle);

        return this;
    }


    public ArticlePage skipOnboardingPopup() {
        try {
            shouldBeVisible(popup, "Onboarding popup not visible", Timeouts.MEDIUM);
            click(popupButtonSkip, "Cannot click Skip Onboarding button");
            System.out.println("Popup was present and closed.");
        } catch (Throwable e) {
            System.out.println("No popup appeared.");
        }
        return this;
    }

    @Step("Делаем свайп до footer статьи")
    public ArticlePage swipeToFooter() {
        SwipeUtils.swipeUpToFindElement(
                driver,
                footerElement,
                "Cannot find the end of the article",
                20
        );
        return this;
    }

    @Step("Добавляем статью в сохранённые")
    public ArticlePage addArticleToSavedList() {
        click(saveButton, "Cannot click Save Article button");
        return this;
    }

    @Step("Сохраняем статью в новую папку '{folderName}' через Snackbar")
    public ArticlePage saveArticleToFolderWithSnackBar(String folderName) {

        click(saveButton);
        click(snackBarActionButton);
        typeText(inputNameOfFolder, folderName, "Cannot find field to write name folder for saved articles" );
        click(saveButtonNameOfFolder,"Cannot press OK button");
        return this;
    }

    @Step("Переходим в список сохранных папок через Snackbar")
    public ArticlePage goToMyListFromSnackBar() {
        click(goToMyListInSnackbar,
                "Cannot find 'view list' in snackbar",
                Timeouts.MEDIUM);
        return this;
    }

    @Step("Возвращается обратно с экрана поиска")
    public ArticlePage navigateBack() {
        click(navigateUp, "Cannot click Navigate Back button");
        return this;
    }
}
