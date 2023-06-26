package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class CareerPage {
    private SelenideElement
            vacationsQa = $(byTagAndText("span", "Вакансии BI.ZONE"));
    public CareerPage vacationsQa(){
        step("Открытие страницы Вакансии",() -> {
            vacationsQa.click();
            switchTo().window(1);
        });
        return this;
    }
}
