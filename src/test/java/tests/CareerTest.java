package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class CareerTest extends TestBase {
    @Test
    @Owner("Kudryavtsev")
    @Feature("Вакансии тестировщика на HH.ru")
    @Story("Проверка вакансии на сайте")
    public void vacationQa() {
        mainPage.openPage();
        mainPage.closeCookie();
        careerPage.companyHover();
        careerPage.openСareer();
        careerHhPage.vacationsQa();
        careerHhPage.buttonVacation();
        careerHhPage.checkoutVacationQa();
    }
}
