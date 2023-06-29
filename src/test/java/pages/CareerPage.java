package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CareerPage {
    private SelenideElement
            companyHover = $(byTagAndText("span","Компания")),
            openСareer = $x("//a[@class='submenu__link'][contains(text(),'Карьера')]"),
            vacationsQa = $(byTagAndText("span", "Вакансии BI.ZONE")),
            buttonVacation = $x("//*[contains(@class, 'tmpl_hh_areas__reset--dt')]"),
            checkoutVacationQa = $(byTagAndText("span", "Тестировщик"));

    public CareerPage openСareer(){
        step("Открытие страницы Карьера",() -> {
            openСareer.click();
        });
        return this;
    }
    public CareerPage companyHover(){
        step("Наведение на название Компания",() -> {
            companyHover.hover();
        });
        return this;
    }
    public CareerPage buttonVacation() {
        step("Нажатие на кнопку \"Работа в BI.ZONE\"", () -> {
            buttonVacation.click();
        });
        return this;
    }
    public CareerPage checkoutVacationQa() {
        step("Проверка наличия вакансии \"Тестировщик\"", () -> {
            checkoutVacationQa.shouldBe(Condition.visible);
            Selenide.closeWindow();
            switchTo().window(0);
        });
        return this;
    }
    public CareerPage vacationsQa(){
        step("Открытие страницы Вакансии",() -> {
            vacationsQa.click();
            switchTo().window(1);
        });
        return this;
    }
}
