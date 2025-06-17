package lib.ui.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.ui.factories.PageFactory;
import lib.utils.Timeouts;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;


public class SearchPage extends BasePage {

    private final SelenideElement
            searchInput = $(androidUIAutomator("new UiSelector().textContains(\"Search Wikipedia\")")),
            emptyInput = $(id("org.wikipedia.alpha:id/search_empty_image")),
            cancelButton = $(id("org.wikipedia.alpha:id/search_close_btn"));

    private final ElementsCollection searchResultContainers =
            $(id("org.wikipedia.alpha:id/search_results_list")).
                    $$(className("android.view.ViewGroup"));

    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));


    public SearchPage(AppiumDriver driver, PageFactory factory) {
        super(driver, factory);
    }

    /* TEMPLATES METHODS */
    private SelenideElement getSearchResultBySubstring(String substring) {
        return $(androidUIAutomator("new UiSelector().text(\"" + substring + "\")"));
    }
    /* TEMPLATES METHODS */

    @Step("Открываем поиск по статьям")
    public SearchPage initSearchInput() {
        click(searchInput, "Cannot click search input");
        return this;
    }
    @Step("Проверяем отображение пустого поиска")
    public SearchPage waitForEmptySearchInput() {
        shouldBeVisible(emptyInput, "Empty state image not visible", Timeouts.SHORT);
        return this;
    }

    @Step("Вводим поисковый запрос: '{searchLine}'")
    public SearchPage typeSearchLine(String searchLine) {
        typeText(searchInput, searchLine, "Cannot type search text", Timeouts.SHORT);
        return this;
    }

    @Step("Проверяем, что найдена статья с заголовком '{substring}'")
    public SearchPage checkTitleSearchResult(String substring) {
        shouldBeVisible(getSearchResultBySubstring(substring),
                "Cannot find article with text: " + substring,
                Timeouts.MEDIUM);
        return this;
    }

    @Step("Проверяем, что среди результатов есть статья '{expectedTitle}' с описанием '{expectedDescription}'")
    public SearchPage checkSearchResult(String expectedTitle, String expectedDescription) {
        searchResultContainers.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(15));

        for (SelenideElement container : searchResultContainers) {
            String title = container.$(id("org.wikipedia.alpha:id/page_list_item_title")).getText();
            String description = container.$(id("org.wikipedia.alpha:id/page_list_item_description")).getText();

            if (title.equals(expectedTitle) && description.equals(expectedDescription)) {
                System.out.println("Found result: " + title + " / " + description);
                return this;
            }
        }
        throw new AssertionError("Cannot find result with title: " + expectedTitle +
                " and description: " + expectedDescription);
    }

    @Step("Открываем статью с заголовком '{substring}'")
    public SearchPage clickByArticleWithSubstring(String substring) {
        click(getSearchResultBySubstring(substring),
                "Cannot click article with text: " + substring,
                Timeouts.MEDIUM);
        return this;
    }

    @Step("Получаем случайную статью из результатов поиска")
    public String getTitleRandomArticle() {
        checkResultsPresent(searchResults, Timeouts.MEDIUM);
        int index = new Random().nextInt(searchResults.size());
        return searchResults.get(index).text();
    }

    @Step("Закрываем окно поиска")
    public SearchPage clickCancelButton() {
        click(cancelButton);
        return this;
    }

    @Step("Проверяем, что есть результаты поиска")
    public SearchPage checkResultsPresent() {
        checkResultsPresent(searchResults, Timeouts.MEDIUM);
        return this;
    }

    @Step("Проверяем, что результаты поиска отсутствуют")
    public SearchPage checkResultsNotPresent() {
        checkResultsAbsent(searchResults, Timeouts.MEDIUM);
        return this;
    }
}
