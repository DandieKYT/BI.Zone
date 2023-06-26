package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement
            vkGroup= $x("//div[normalize-space()='VK']"),
            materialsOpen =  $(byTagAndText("a", "Материалы")),
            openСareer = $x("//a[@class='submenu__link'][contains(text(),'Карьера')]"),
            openProducts = $x("//a[text()='Продукты и услуги']"),
            closeCookie = $(".v-cookie__button > svg > path"),
            expertiseHover = $(byTagAndText("span","Экспертиза")),
            companyHover = $(byTagAndText("span","Компания"));
}
