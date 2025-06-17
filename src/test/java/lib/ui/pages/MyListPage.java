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

public class MyListPage extends BasePage {

    public MyListPage(AppiumDriver driver, PageFactory factory) {
        super(driver, factory);
    }

    private final SelenideElement
            closePopupButton = $(id("org.wikipedia.alpha:id/buttonView")),
            emptyFolderText = $(id("org.wikipedia.alpha:id/reading_list_empty_text")),
            moreOptionsButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            createNewListButton = $(id("org.wikipedia.alpha:id/reading_lists_overflow_create_new_list")),
            inputNameOfFolder = $(id("org.wikipedia.alpha:id/text_input")),
            saveButtonNameOfFolder = $(id("android:id/button1")),
            folderActionMenu = $(androidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")),
            deleteListOption = $(androidUIAutomator("new UiSelector().text(\"Delete list\")")),
            confirmDeleteButton = $(id("android:id/button1"));

    /* TEMPLATES METHODS */
    private SelenideElement getFolderElementByTitle(String text) {
        return $(androidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/item_title\").text(\"" + text + "\")"));
    }

    private SelenideElement getArticleElementByTitle(String text) {
        return $(androidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/page_list_item_title\").text(\"" + text + "\")"));
    }
    /* TEMPLATES METHODS */

    @Step("Открываем папку с именем '{folderName}'")
    public MyListPage openFolderByName(String folderName) {
        click(getFolderElementByTitle(folderName));
        return this;
    }
    @Step("Закрываем popup")
    public MyListPage closePopup() {
        try {
            shouldBeVisible(closePopupButton, "Cannot find popup", Timeouts.MEDIUM);
            click(closePopupButton, "Cannot close popup");
        } catch (Exception e) {
            System.out.println("Popup not displayed, skipping close.");
        }
        return this;
    }

    @Step("Удаляем статью '{titleArticle}' свайпом влево")
    public MyListPage removeArticleBySwiping(String titleArticle) {
        SelenideElement title = getArticleElementByTitle(titleArticle);
        shouldBeVisible(title, "Cannot swipe element to left");
        SwipeUtils.swipeElementToLeft(driver, title);
        return this;
    }

    @Step("Проверяем, что папка пустая")
    public MyListPage checkEmptyFolder() {
        shouldBeVisible(emptyFolderText,
                "Cannot find text 'You have no articles added to this list.'");
        return this;
    }

    @Step("Проверяем, что сохранена статья '{titleArticle}'")
    public MyListPage checkSavedArticle(String titleArticle) {
        shouldBeVisible(getArticleElementByTitle(titleArticle),
                "Cannot find saved article in folder");
        return this;
    }

    @Step("Открываем меню опций в папке")
    public MyListPage selectOptions() {
        click(moreOptionsButton, "Cannot find options button");
        return this;
    }

    @Step("Создаём новую папку с именем '{folderName}'")
    public MyListPage createNewFolder(String folderName) {
        click(createNewListButton, "Cannot find 'Create New folder' button");
        typeText(inputNameOfFolder, folderName, "Cannot find field to write name folder for saved articles");
        click(saveButtonNameOfFolder, "Cannot press OK button");
        return this;
    }

    @Step("Проверяем, что папка '{folderName}' создана")
    public MyListPage checkCreatedFolder(String folderName) {
        shouldBeVisible(getFolderElementByTitle(folderName), "Cannot find created folder " + folderName);
        return this;
    }

    @Step("Открываем опции для папки '{folderName}'")
    public MyListPage selectOptionsFolder(String folderName) {
        SelenideElement folder = getFolderElementByTitle(folderName);
        shouldBeVisible(folder,"Cannot long tap element");
        SwipeUtils.longTap(driver, folder);
        shouldBeVisible(folderActionMenu, "Cannot find options folder");
        return this;
    }

    @Step("Удаляем папку через опции")
    public MyListPage deleteFolderFromOptions() {
        click(deleteListOption, "Cannot find 'Delete list' option");
        click(confirmDeleteButton, "Cannot find popup 'Are you sure you want to delete");
        return this;
    }

    @Step("Проверяем, что папка '{folderName}' отсутствует")
    public MyListPage checkFolderIsAbsent(String folderName) {
        shouldNOtBeVisible(getFolderElementByTitle(folderName), "Cannot find created folder " + folderName);
        return this;
    }
}
