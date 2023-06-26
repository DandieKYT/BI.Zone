package tests;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.*;


@Tag("remote_test")
public class BiZoneTest extends TestBase {
    VkPage vkPage = new VkPage();
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    CareerPage careerPage = new CareerPage();
    HhPage hhPage = new HhPage();
    MaterialsPage materialsPage = new MaterialsPage();
    ParamPage paramPage = new ParamPage();

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
        paramPage.searchByParam(param);
        paramPage.openTitle(expectedText);
        paramPage.checkTile(expectedText);
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
        careerPage.vacationsQa();
        hhPage.buttonVacation();
        hhPage.checkoutVacationQa();
    }

    @Test
    @Owner("Kudryavtsev")
    @Feature("Чтение и проверка содержимого PDF файла")
    @Story("Проверка PDF файла")
    public void pdfTest() throws Exception {
        mainPage.openPage();
        mainPage.expertiseHover();
        mainPage.materialsOpen();
        materialsPage.findBook();
        materialsPage.bookPageOpen();
        materialsPage.checkoutPDF();
        materialsPage.closeAfterPDF();
    }
}

