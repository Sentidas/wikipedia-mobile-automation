package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lib.core.CoreTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Epic("Сохраненные списки")
@Feature("Сохранение и удаление статей")
public class SavedArticlesTest extends CoreTestCase {

    @Test
    @DisplayName("Добавление статьи в избранное через Snackbar и проверка наличия в списке сохраненных статей")
    @Severity(SeverityLevel.NORMAL)
    @Tag("regress")
    @Tag("full")
    void saveArticleToMyListWithSnackBar() {
        pages.
                search().initSearchInput()
                .typeSearchLine("Java")
                .getTitleRandomArticle();
        String titleArticle = pages.search().getTitleRandomArticle();
        System.out.println("Заголовок статьи " + titleArticle);
        pages.search().clickByArticleWithSubstring(titleArticle);


        pages.article().skipOnboardingPopup();

        String folderName = "my favorite articles";
        pages.article().saveArticleToFolderWithSnackBar(folderName)
                .goToMyListFromSnackBar();

        pages.myList().closePopup()
                .checkSavedArticle(titleArticle);
    }

    @Test
    @DisplayName("Сохранение и удаление скроллом одной статьи из списка сохраненных")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("regress")
    @Tag("full")
    void savedAndRemoveOneArticle() {
        pages.
                search().initSearchInput()
                .typeSearchLine("Java");

        String titleArticle = pages.search().getTitleRandomArticle();
        System.out.println("Заголовок статьи " + titleArticle);
        pages.search().clickByArticleWithSubstring(titleArticle);

        pages.article().skipOnboardingPopup()
                .addArticleToSavedList()
                .navigateBack()
                .navigateBack();

        pages.navigation().selectSavedArticlesTab();

        pages.myList().openFolderByName("Saved")
                .closePopup()
                .removeArticleBySwiping(titleArticle)
                .checkEmptyFolder();
    }
}
