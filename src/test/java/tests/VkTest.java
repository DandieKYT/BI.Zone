package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class VkTest extends TestBase {
    @Test
    @Owner("Kudryavtsev")
    @Feature("Переход на официальную страницу группы компании в ВК")
    @Story("Проверка соответствия группы с названием")
    public void groupLinks() {
        mainPage.openPage();
        vkPage.vkGroup();
        vkPage.getExpectedTitleVk();
    }
}
