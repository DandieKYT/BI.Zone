package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CareerAndCompanyTest extends TestBase{
    @Tag("BizoneTest")
    @Tag("CareerAndCompanyTest")
    @CsvSource(value = {
            "Экспертиза,         Материалы",
            "Компания,             Карьера",
    })
    @Owner("Kudryavtsev")
    @Feature("Материалы и Карьера")
    @Story("Открытие страниц Материалы и Карьера")
    @ParameterizedTest
    public void careerAndCompany(String param, String expectedText) {
        startTest.openPage();
        startTest.closeCookie();
        careerAndCompanyPage.searchByParam(param);
        careerAndCompanyPage.openTitle(expectedText);
        careerAndCompanyPage.checkTile(expectedText);
    }
}
