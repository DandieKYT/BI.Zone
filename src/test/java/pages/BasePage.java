package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class BasePage extends TestBase {
    public SelenideElement
            closeCookie = $(".v-cookie__button > svg > path");
    public BasePage closeCookie() {
        step("Закрытие уведомления cookie", () -> {
            closeCookie.click();
        });
        return this;
    }

    public BasePage openPage() {
        step("Открытие сайта", () -> {
            Selenide.open("/");
        });
        return this;
    }
}
