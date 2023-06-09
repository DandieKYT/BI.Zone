package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProductTest extends TestBase {
    @Tag("BizoneTest")
    @Tag("ProductTest")
    @Test
    @Owner("Kudryavtsev")
    @Feature("Соответствие результатов выдачи во вкладке продукты")
    @Story("Проверка вкладки работы Продукты")
    @Tag("api_allure")
    public void productsResult() {
        basePage.openPage();
        basePage.closeCookie();
        productPage.openProducts();
        productPage.checkBoxLocal();
        productPage.checkBoxHome();
        productPage.expectedProducts();
    }
}
