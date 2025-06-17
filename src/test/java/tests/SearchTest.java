package tests;

import lib.core.CoreTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends CoreTestCase {

    @Test
    @DisplayName("Поиск: отображение ожидаемой статьи по запросу")
    void searchReturnsExpectedArticle() {

        pages.search().initSearchInput()
                .typeSearchLine("Java")
                .checkSearchResult(
                        "Java (programming language)",
                        "Object-oriented programming language");
    }

    @Test
    @DisplayName("Поиск: очистка результатов после отмены поиска")
    void searchResultsDisappearAfterCancel() {

        pages.search().initSearchInput()
                .typeSearchLine("Java")
                .clickCancelButton()
                .waitForEmptySearchInput();
    }

    @Test
    @DisplayName("Поиск: отображение нескольких результатов по запросу")
    void searchMultipleArticles() {

        String searchLine = "Linkin Park Discography";

        pages.search().initSearchInput()
                .typeSearchLine(searchLine)
                .checkResultsPresent();
    }

    @Test
    @DisplayName("Поиск: отсутствие результатов при некорректном поисковом запросе")
    void emptySearchReturnsNoResults() {

        String searchLine = "Linkin Park Discography33333333333333333333333333333333333";

        pages.search().initSearchInput()
                .typeSearchLine(searchLine)
                .checkResultsNotPresent();
    }
}
