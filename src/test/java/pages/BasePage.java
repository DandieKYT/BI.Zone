package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public SelenideElement
            closeCookie = $(".v-cookie__button > svg > path");
}
