package tests;

import lib.core.CoreTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FolderTest extends CoreTestCase {

    @Test
    @DisplayName("Создание новой папки в разделе 'Сохранённые статьи'")
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
