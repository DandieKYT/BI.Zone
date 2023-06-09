package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BiZonePage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class BiZoneSteps {
    BiZonePage biZonePage = new BiZonePage();

    @Step("Открытие верхнего меню")
    public void searchByParam(String param) {
        biZonePage.searchByParam(param).hover();
    }

    @Step("Открытие сайта")
    public BiZoneSteps openPage() {
        Selenide.open("https://bi.zone/");
        return this;
    }

    @Step("Скриншот теста")
    public void attachScreenshot(int number) {
        $(withText("#" + number)).should(Condition.visible);
        attachScreenshot();
    }

    @Step("Page Source")
    @Attachment(value = "Page Source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }


    @Step("Открытие вкладки продукты")
    public void openProducts() {
        biZonePage.openProducts().click();
    }

    @Step("Закрытие уведомления cookie")
    public void closeCookie() {
        biZonePage.closeCookie().click();
    }

    @Step("Ставим отметку в чек-бокс в Локальное")
    public void checkBoxLocal() {
        biZonePage.checkBoxLocal().click();
    }

    @Step("Ставим отметку в чек-бокс в Реестр отечественного ПО")
    public void checkBoxHome() {
        biZonePage.checkBoxHome().click();
    }

    @Step("Проверка на соответсвие количества результатов")
    public void expectedProducts() {
        biZonePage.expectedProducts().shouldHave(text("7 результатов"));
    }

    @Step("Открытие вкладки")
    public void openTitle(String expectedText) {
        biZonePage.openTitle(expectedText).click();
    }

    @Step("Проверка открытия вкладки")
    public void checkTile(String expectedText) {
        biZonePage.checkTile(expectedText).shouldBe(text(expectedText));
    }

    @Step("Наведение курсора на название Экспертиза")
    public void expertiseHover() {
        biZonePage.expertiseHover().hover();
    }

    @Step("Открытие страницы материалы")
    public void materialsOpen() {
        biZonePage.materialsOpen().click();
    }

    @Step("Открытие страницы с книгой")
    public void bookPageOpen() {
        biZonePage.bookPageOpen().click();
        switchTo().window(2);
    }

    @Step("Скачивание PDF файла, и его проверка")
    public void checkoutPDF() throws IOException {
        biZonePage.checkoutPDF();
    }

    @Step("Открытие группы ВК")
    public void getVkGroup() {
        biZonePage.getVkGroup().click();
        switchTo().window(2);
    }

    @Step("Проверка названия в группе ВК")
    public void getExpectedTitleVk() {
        biZonePage.getExpectedTitleVk().shouldBe(text("BI.ZONE"));
    }

    @Step("Наведение на название Компания")
    public void companyHover() {
        biZonePage.companyHover().hover();
    }

    @Step("Открытие страницы Карьера")
    public void openСareer() {
        biZonePage.openСareer().click();
    }

    @Step("Открытие страницы Вакансии")
    public void vacationsQa() {
        biZonePage.vacationsQa().click();
        switchTo().window(1);
    }

    @Step("Нажатие на кнопку \"Работа в BI.ZONE\"")
    public void buttonVacation() {
        biZonePage.buttonVacation().click();
    }

    @Step("Открытие списка вакасий")
    public void listVacations() {
        biZonePage.listVacations().click();
    }

    @Step("Проверка наличия вакансии \"Тестировщик\"")
    public void checkoutVacationQa() {
        biZonePage.checkoutVacationQa().shouldBe(Condition.visible);
    }

    @Step("Получение логов браузера")
    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static void browserLogs() {
        attachAsText(
                "Browser console log",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    @Attachment(value = "Скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Step("Получение записи видео теста")
    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src ='"
                + getVideoUrl()
                + "' type='video/mp4'></video></body></html>";

    }

    public static URL getVideoUrl() {
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
        try{
            return new URL(videoUrl);
        }   catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}