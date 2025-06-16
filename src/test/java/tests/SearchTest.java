package tests;

import lib.core.CoreTestCase;
import org.junit.jupiter.api.Test;

public class SearchTest extends CoreTestCase {

    @Test
    void searchReturnsExpectedArticle() {

        pages.search().initSearchInput()
                .typeSearchLine("Java")
                .checkSearchResult(
                        "Java (programming language)",
                        "Object-oriented programming language");
    }

    @Test
    void searchResultsDisappearAfterCancel() {

        pages.search().initSearchInput()
                .typeSearchLine("Java")
                .clickCancelButton()
                .waitForEmptySearchInput();
    }

    @Test
    void searchMultipleArticles() {
        String searchLine = "Linkin Park Discography";

        pages.search().initSearchInput()
                .typeSearchLine(searchLine)
                .checkResultsPresent();
    }

    @Test
    void emptySearchReturnsNoResults() {
        String searchLine = "Linkin Park Discography33333333333333333333333333333333333";

        pages.search().initSearchInput()
                .typeSearchLine(searchLine)
                .checkResultsNotPresent();
    }
}
