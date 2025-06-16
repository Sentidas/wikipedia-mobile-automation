package tests;

import lib.core.CoreTestCase;
import org.junit.jupiter.api.Test;

public class ArticleTest extends CoreTestCase {

    @Test
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
