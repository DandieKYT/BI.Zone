package pages;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class CareerAndCompanyPage {
    MainPage mainPage = new MainPage();
    public MainPage searchByParam(String param){
        step("Открытие верхнего меню",() -> {
            mainPage.searchByParam(param).hover();
        });
        return null;
    }
    public MainPage openTitle(String expectedText){
        step("Открытие вкладки",() -> {
            mainPage.openTitle(expectedText).click();
        });
        return null;
    }
    public MainPage checkTile(String expectedText){
        step("Проверка открытия вкладки",() -> {
            mainPage.checkTitle(expectedText).shouldBe(text(expectedText));
        });
        return null;
    }
}
