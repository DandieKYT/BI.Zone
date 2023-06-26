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

    @Step("Открытие вкладки")
    public void openTitle(String expectedText) {
        startPage.openTitle(expectedText).click();
    }

    @Step("Проверка открытия вкладки")
    public void checkTile(String expectedText) {
        startPage.checkTile(expectedText).shouldBe(text(expectedText));
    }

    @Step("Открытие списка вакасий")
    public void listVacations() {
        startPage.listVacations().click();
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