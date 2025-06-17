package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lib.core.CoreTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Статьи")
@Feature("Действия с открытой статьей")
public class ArticleTest extends CoreTestCase {

    @Test
    @DisplayName("Открытие статьи и проверка её заголовка")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("regress")
    @Tag("full")
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
    @DisplayName("Скролл случайной статьи до футера после открытия")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("regress")
    @Tag("full")
    void swipeRandomArticleTest() {
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
