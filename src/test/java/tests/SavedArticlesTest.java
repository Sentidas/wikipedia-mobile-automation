package tests;

import lib.core.CoreTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavedArticlesTest extends CoreTestCase {

    @Test
    @DisplayName("Добавление статьи в избранное через Snackbar и проверка наличия в списке сохраненных статей")
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
