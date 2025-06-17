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
@Feature("Создание и удаление папок")
public class FolderTest extends CoreTestCase {

    @Test
    @DisplayName("Создание новой папки в разделе 'Сохранённые статьи'")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("regress")
    @Tag("full")
    void createEmptyFolderFromOptionsMyList() {
        pages.navigation().selectSavedArticlesTab();
        String folderName = "my list";
        pages.myList()
                .selectOptions()
                .createNewFolder(folderName)
                .checkCreatedFolder(folderName);
    }

    @Test
    @DisplayName("Удаление созданной папки из списка 'Сохранённые статьи'")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("regress")
    @Tag("full")
    void removeCreatedFolderFromSavedList() {
        pages.navigation().selectSavedArticlesTab();
        String folderName = "my list";
        pages.myList()
                .selectOptions()
                .createNewFolder(folderName)
                .selectOptionsFolder(folderName)
                .deleteFolderFromOptions()
                .checkFolderIsAbsent(folderName);
    }
}
