package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CareerTest extends TestBase {
    @Tag("BizoneTest")
    @Tag("CareerTest")
    @Test
    @Owner("Kudryavtsev")
    @Feature("Вакансии тестировщика на HH.ru")
    @Story("Проверка вакансии на сайте")
    public void vacationQa() {
        basePage.openPage();
        basePage.closeCookie();
        careerPage.companyHover();
        careerPage.openСareer();
        careerPage.vacationsQa();
        careerPage.buttonVacation();
        careerPage.checkoutVacationQa();
    }
}
