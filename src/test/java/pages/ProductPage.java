package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ProductPage {
    private SelenideElement
            expectedProducts = $(".cFiltered__length"),
            openProducts = $x("//a[text()='Продукты и услуги']"),
            checkBoxHome = $x("//*[contains(@class, 'catalog__filterContent')]//div[text()='Реестр отечественного ПО']"),
            checkBoxLocal = $x( "//*[contains(@class, 'catalog__filterContent')]//div[text()='Локальное']");

    public ProductPage expectedProducts(){
        step("Проверка на соответсвие количества результатов",() -> {
            expectedProducts.shouldHave(text("7 результатов"));
        });
        return this;
    }
    public ProductPage openProducts(){
        step("Открытие страницы Продукты",() -> {
            openProducts.click();
        });
        return this;
    }
    public ProductPage checkBoxHome(){
        step("Ставим отметку в чек-бокс в Реестр отечественного ПО",() -> {
            checkBoxHome.click();
        });
        return this;
    }
    public ProductPage checkBoxLocal(){
        step("Ставим отметку в чек-бокс в Локальное",() -> {
            checkBoxLocal.click();
        });
        return this;
    }
}
