package tests;

import io.qameta.allure.*;
import lib.annotaions.KnownIssue;
import lib.core.CoreTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Поиск статей")
@Feature("Работа с поисковой строкой")
public class SearchTest extends CoreTestCase {

    @Test
    @DisplayName("Поиск: отображение ожидаемой статьи по запросу")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("regress")
    @Tag("full")
    void searchReturnsExpectedArticle() {

        pages.search().initSearchInput()
                .typeSearchLine("Java")
                .checkSearchResult(
                        "Java (programming language1)",
                        "Object-oriented programming language");
    }

    @Test
    @DisplayName("Поиск: очистка результатов после отмены поиска")
    @Severity(SeverityLevel.NORMAL)
    @Tag("regress")
    @Tag("review")
    void searchResultsDisappearAfterCancel() {

        Allure.description("Требует ревью из-за обновления API поиска - Feature-569432");

        pages.search().initSearchInput()
                .typeSearchLine("Java")
                .clickCancelButton()
                .waitForEmptySearchInput();
    }

    @Test
    @DisplayName("Поиск: отображение нескольких результатов по запросу")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")

    void searchMultipleArticles() {

        String searchLine = "Linkin Park Discography";

        pages.search().initSearchInput()
                .typeSearchLine(searchLine)
                .checkResultsPresent();
    }

    @KnownIssue("BUG-568900")
    @Issue("BUG-568900")
    // @Disabled("Отключен до фикса BUG-568900")
    @Test
    @DisplayName("Поиск: отсутствие результатов при некорректном поисковом запросе")
    void emptySearchReturnsNoResults() {

        String searchLine = "Linkin Park Discography33333333333333333333333333333333333";

        pages.search().initSearchInput()
                .typeSearchLine(searchLine)
                .checkResultsPresent();
    }
}
