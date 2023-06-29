package tests;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



@Tag("remote_test")
public class BiZoneTestSuit extends TestBase {

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
        careerAndCompanyPage.searchByParam(param);
        careerAndCompanyPage.openTitle(expectedText);
        careerAndCompanyPage.checkTile(expectedText);
    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Соответствие результатов выдачи во вкладке продукты")
    @Story("Проверка вкладки работы Продукты")
    @Tag("api_allure")
    public void productsResult() {
        mainPage.openPage();
        productPage.openProducts();
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
        vkPage.vkGroup();
        vkPage.getExpectedTitleVk();
    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Вакансии тестировщика на HH.ru")
    @Story("Проверка вакансии на сайте")
    public void vacationQa() {
        mainPage.openPage();
        mainPage.closeCookie();
        careerPage.companyHover();
        careerPage.openСareer();
        careerPage.vacationsQa();
        careerPage.buttonVacation();
        careerPage.checkoutVacationQa();
    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Чтение и проверка содержимого PDF файла")
    @Story("Проверка PDF файла")
    public void materialsPdfTest() throws Exception {
        mainPage.openPage();
        materialsPage.expertiseHover();
        materialsPage.materialsOpen();
        materialsPage.findBook();
        materialsPage.bookPageOpen();
        materialsPage.checkoutPDF();
        materialsPage.closeAfterPDF();
    }
}

