package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {
    private SelenideElement

            closeCookie = $(".v-cookie__button > svg > path"),
            expertiseHover = $(byTagAndText("span","Экспертиза")),
            companyHover = $(byTagAndText("span","Компания"));



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
    public MainPage expertiseHover(){
        step("Наведение курсора на название Экспертиза",() -> {
            expertiseHover.hover();
        });
        return this;
    }
    public MainPage companyHover(){
        step("Наведение на название Компания",() -> {
            companyHover.hover();
        });
        return this;
    }
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
