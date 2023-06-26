package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.StartPage;

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
    StartPage startPage = new StartPage();

    @Step("Открытие верхнего меню")
    public void searchByParam(String param) {
        startPage.searchByParam(param).hover();
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
        startPage.openProducts().click();
    }

    @Step("Ставим отметку в чек-бокс в Локальное")
    public void checkBoxLocal() {
        startPage.checkBoxLocal().click();
    }

    @Step("Ставим отметку в чек-бокс в Реестр отечественного ПО")
    public void checkBoxHome() {
        startPage.checkBoxHome().click();
    }

    @Step("Проверка на соответсвие количества результатов")
    public void expectedProducts() {
        startPage.expectedProducts().shouldHave(text("7 результатов"));
    }

    @Step("Открытие вкладки")
    public void openTitle(String expectedText) {
        startPage.openTitle(expectedText).click();
    }

    @Step("Проверка открытия вкладки")
    public void checkTile(String expectedText) {
        startPage.checkTile(expectedText).shouldBe(text(expectedText));
    }

    @Step("Наведение курсора на название Экспертиза")
    public void expertiseHover() {
        startPage.expertiseHover().hover();
    }

    @Step("Открытие страницы материалы")
    public void materialsOpen() {
        startPage.materialsOpen().click();
    }

    @Step("Открытие страницы с книгой")
    public void bookPageOpen() {
       $x("//*[contains(@class, 'catalog__input')]").setValue("Путь к цифровому лидерству. Основы управления непрерывностью бизнеса").pressEnter();
        startPage.bookPageOpen().click();
        switchTo().window(1);
    }

    @Step("Скачивание PDF файла, и его проверка")
    public void checkoutPDF() throws IOException {
        startPage.checkoutPDF();
        Selenide.closeWindow();
        switchTo().window(0);
    }

    @Step("Проверка названия в группе ВК")
    public void getExpectedTitleVk() {
        startPage.getExpectedTitleVk().shouldBe(text("BI.ZONE"));
        Selenide.closeWindow();
        switchTo().window(0);
    }

    @Step("Наведение на название Компания")
    public void companyHover() {
        startPage.companyHover().hover();
    }

    @Step("Открытие страницы Карьера")
    public void openСareer() {
        startPage.openСareer().click();
    }

    @Step("Открытие страницы Вакансии")
    public void vacationsQa() {
        startPage.vacationsQa().click();
        switchTo().window(1);
    }

    @Step("Нажатие на кнопку \"Работа в BI.ZONE\"")
    public void buttonVacation() {
        startPage.buttonVacation().click();
    }

    @Step("Открытие списка вакасий")
    public void listVacations() {
        startPage.listVacations().click();
    }

    @Step("Проверка наличия вакансии \"Тестировщик\"")
    public void checkoutVacationQa() {
        startPage.checkoutVacationQa().shouldBe(Condition.visible);
        Selenide.closeWindow();
        switchTo().window(0);
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