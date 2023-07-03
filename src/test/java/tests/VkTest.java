package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class VkTest extends TestBase {
    @Tag("BizoneTest")
    @Tag("VkTest")
    @Test
    @Owner("Kudryavtsev")
    @Feature("Переход на официальную страницу группы компании в ВК")
    @Story("Проверка соответствия группы с названием")
    public void groupLinks() {
        basePage.openPage();
        basePage.closeCookie();
        vkPage.vkGroup();
        vkPage.getExpectedTitleVk();
    }
}
