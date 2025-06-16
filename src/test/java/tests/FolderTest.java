package tests;

import lib.core.CoreTestCase;
import org.junit.jupiter.api.Test;

public class FolderTest extends CoreTestCase {

    @Test
    void createEmptyFolderFromOptionsMyList() {
        pages.navigation().selectSavedArticlesTab();
        String folderName = "my list";
        pages.myList()
                .selectOptions()
                .createNewFolder(folderName)
                .checkCreatedFolder(folderName);
    }

    @Test
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
