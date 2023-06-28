package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class PdfTest extends TestBase{
    @Test
    @Owner("Kudryavtsev")
    @Feature("Чтение и проверка содержимого PDF файла")
    @Story("Проверка PDF файла")
    public void pdfTest() throws Exception {
        mainPage.openPage();
        mainPage.expertiseHover();
        materialsPage.materialsOpen();
        materialsPage.findBook();
        materialsPage.bookPageOpen();
        materialsPage.checkoutPDF();
        materialsPage.closeAfterPDF();
    }
}
