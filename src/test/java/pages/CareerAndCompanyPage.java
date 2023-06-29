package pages;

import com.codeborne.selenide.SelenideElement;
import help.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class CareerAndCompanyPage {
    CareerAndCompanyLocators locators = new CareerAndCompanyLocators();

    public MainPage searchByParam(String param){
        step("Открытие верхнего меню",() -> {
            locators.searchByParam(param).hover();
        });
        return null;
    }
    public MainPage openTitle(String expectedText){
        step("Открытие вкладки",() -> {
            locators.openTitle(expectedText).click();
        });
        return null;
    }
    public MainPage checkTile(String expectedText){
        step("Проверка открытия вкладки",() -> {
            locators.checkTitle(expectedText).shouldBe(text(expectedText));
        });
        return null;
    }
    public class CareerAndCompanyLocators{
        public SelenideElement searchByParam(String param){
            return $x(String.format("//span[text()='%s']", param));
        }

        public SelenideElement openTitle(String expectedText){
            return $(byTagAndText("a", (expectedText)));
        }
        public SelenideElement checkTitle(String expectedText){
            return $x(String.format("//h1[text()='%s']", expectedText));
        }
    }
}
