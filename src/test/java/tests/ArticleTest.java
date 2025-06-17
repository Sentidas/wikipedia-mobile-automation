package tests;

import lib.core.CoreTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArticleTest extends CoreTestCase {

    @Test
    @DisplayName("Открытие статьи и проверка её заголовка")
    void compareArticleTitle() {
        pages.
                search().initSearchInput()
                .typeSearchLine("Java")
                .getTitleRandomArticle();

        String titleArticle = pages.search().getTitleRandomArticle();
        System.out.println("Заголовок статьи " + titleArticle);
        pages.search().clickByArticleWithSubstring(titleArticle);

        pages.
                article().skipOnboardingPopup()
                .checkTextInArticle(titleArticle);
    }

    @Test
    @DisplayName("Скролл статьи до футера после открытия")
    void swipeArticleTest() {
        pages.
                search().initSearchInput()
                .typeSearchLine("Appium")
                .getTitleRandomArticle();

        String titleArticle = pages.search().getTitleRandomArticle();
        System.out.println(titleArticle);

        pages.search().clickByArticleWithSubstring(titleArticle);
        pages.
                article().skipOnboardingPopup()
                .checkTextInArticle(titleArticle)
                .swipeToFooter();
    }
}
