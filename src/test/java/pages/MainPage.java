package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {
    private SelenideElement
            vkGroup= $x("//div[normalize-space()='VK']"),
            materialsOpen =  $(byTagAndText("a", "Материалы")),
            openСareer = $x("//a[@class='submenu__link'][contains(text(),'Карьера')]"),
            openProducts = $x("//a[text()='Продукты и услуги']"),
            closeCookie = $(".v-cookie__button > svg > path"),
            expertiseHover = $(byTagAndText("span","Экспертиза")),
            companyHover = $(byTagAndText("span","Компания"));

    public MainPage vkGroup() {
        step("Открыть группу VK", () -> {
            vkGroup.click();
            switchTo().window(1);
        });
        return this;
    }
    public MainPage closeCookie(){
        step("Закрытие уведомления cookie",() -> {
            closeCookie.click();
        });
        return this;
    }
    public MainPage openPage(){
        step("Открытие сайта",() -> {
            Selenide.open("https://bi.zone/");
        });
        return this;
    }

}
