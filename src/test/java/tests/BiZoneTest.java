package tests;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.ProductPage;
import pages.VkPage;
import steps.BiZoneSteps;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

@Tag("remote_test")
public class BiZoneTest extends TestBase {
    BiZoneSteps biZoneSteps = new BiZoneSteps();
    VkPage vkPage = new VkPage();
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();

    @CsvSource(value = {
            "Экспертиза,         Материалы",
            "Компания,             Карьера",
    })
    @Owner("Kudryavtsev")
    @Feature("Материалы и Карьера")
    @Story("Открытие страниц Материалы и Карьера")
    @ParameterizedTest
    public void careerAndCompany(String param, String expectedText) {
        mainPage.openPage();
        biZoneSteps.searchByParam(param);
        biZoneSteps.openTitle(expectedText);
        biZoneSteps.checkTile(expectedText);
    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Соответствие результатов выдачи во вкладке продукты")
    @Story("Проверка вкладки работы Продукты")
    @Tag("api_allure")
    public void productsResult() {
        mainPage.openPage();
        mainPage.openProducts();
        productPage.checkBoxLocal();
        productPage.checkBoxHome();
        productPage.expectedProducts();
    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Переход на официальную страницу группы компании в ВК")
    @Story("Проверка соответствия группы с названием")
    public void groupLinks() {
        mainPage.openPage();
        mainPage.vkGroup();
        vkPage.getExpectedTitleVk();

    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Вакансии тестировщика на HH.ru")
    @Story("Проверка вакансии на сайте")
    public void vacationQa() {
        mainPage.openPage();
        mainPage.closeCookie();
        mainPage.companyHover();
        mainPage.openСareer();
        biZoneSteps.vacationsQa();
        biZoneSteps.buttonVacation();
        biZoneSteps.checkoutVacationQa();
    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Чтение и проверка содержимого PDF файла")
    @Story("Проверка PDF файла")
    public void pdfTest() throws Exception {
        mainPage.openPage();
        mainPage.expertiseHover();
        mainPage.materialsOpen();
        biZoneSteps.bookPageOpen();
        biZoneSteps.checkoutPDF();
    }
}

