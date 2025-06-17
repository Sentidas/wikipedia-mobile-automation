package tests;

import io.qameta.allure.*;
import lib.annotaions.KnownIssue;
import lib.core.CoreTestCase;
import lib.utils.AppLifecycleUtils;
import lib.utils.RotationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Стабильность приложения при изменении состояния устройства")
@Feature("Ориентация экрана и поведение при сворачивании")
public class OrientationAndBackgroundTests extends CoreTestCase {

    @Test
    @DisplayName("Проверка отображения заголовка статьи при смене ориентации экрана")
    @Severity(SeverityLevel.NORMAL)
    @Tag("full")
    void changesScreenOrientationOnSearchResults() {

        pages.
                search().initSearchInput()
                .typeSearchLine("Java")
                .getTitleRandomArticle();
        String titleArticle = pages.search().getTitleRandomArticle();
        System.out.println(titleArticle);

        pages.search().clickByArticleWithSubstring(titleArticle);

        pages.article().skipOnboardingPopup()
                .checkTextInArticle(titleArticle);

        RotationUtils.rotateScreenLandscape(driver);
        pages.article().checkTextInArticle(titleArticle);

        RotationUtils.rotateScreenPortrait(driver);
        pages.article().checkTextInArticle(titleArticle);
    }

    @Test
    @DisplayName("Проверка сохранения результатов поиска после сворачивания и возврата в приложение")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("regress")
    @Tag("full")
    void checkSearchArticleInBackground() {
        pages.
                search().initSearchInput()
                .typeSearchLine("Java")
                .checkSearchResult(
                        "Java (programming language)",
                        "Object-oriented programming language");

        AppLifecycleUtils.runAppInBackground(driver, 3);

        pages.search().checkSearchResult(
                "Java (programming language)",
                "Object-oriented programming language");
    }
}
