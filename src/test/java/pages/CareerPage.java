package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CareerPage {
    private SelenideElement
            companyHover = $(byTagAndText("span","Компания")),
            openСareer = $x("//a[@class='submenu__link'][contains(text(),'Карьера')]");

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
}
