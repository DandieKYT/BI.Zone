package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MaterialsTest extends TestBase {
    @Tag("BizoneTest")
    @Tag("MaterialsTest")
    @Test
    @Owner("Kudryavtsev")
    @Feature("Чтение и проверка содержимого PDF файла")
    @Story("Проверка PDF файла")
    public void pdfTest() throws Exception {
        startTest.openPage();
        startTest.closeCookie();
        materialsPage.expertiseHover();
        materialsPage.materialsOpen();
        materialsPage.findBook();
        materialsPage.bookPageOpen();
        materialsPage.checkoutPDF();
        materialsPage.closeAfterPDF();
    }
}
