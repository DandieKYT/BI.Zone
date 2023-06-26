package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class HhPage {
    private SelenideElement
            buttonVacation = $x("//*[contains(@class, 'tmpl_hh_areas__reset--dt')]"),
            checkoutVacationQa = $(byTagAndText("span", "Тестировщик"));

    public HhPage buttonVacation() {
        step("Нажатие на кнопку \"Работа в BI.ZONE\"", () -> {
            buttonVacation.click();
        });
        return this;
    }
    public HhPage checkoutVacationQa() {
        step("Проверка наличия вакансии \"Тестировщик\"", () -> {
            checkoutVacationQa.shouldBe(Condition.visible);
            Selenide.closeWindow();
            switchTo().window(0);
        });
        return this;
    }
}
