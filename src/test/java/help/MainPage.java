package help;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {
    private SelenideElement

            closeCookie = $(".v-cookie__button > svg > path");

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
