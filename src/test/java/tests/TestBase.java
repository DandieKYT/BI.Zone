package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import help.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;


import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


public class TestBase extends Attachment {
    VkPage vkPage = new VkPage();
    StartTest startTest = new StartTest();
    ProductPage productPage = new ProductPage();
    CareerPage careerPage = new CareerPage();
    MaterialsPage materialsPage = new MaterialsPage();
    CareerAndCompanyPage careerAndCompanyPage = new CareerAndCompanyPage();
    Attachment attachment = new Attachment();
    @BeforeAll
    static void setUp() {
    Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://bi.zone";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }
        @AfterEach
        void attachemts(){
            attachment.browserLogs();
            attachment.attachScreenshot();
            attachment.pageSource();
            attachment.addVideo();
        }

    public static class StartTest extends BasePage {

        public StartTest closeCookie(){
            step("Закрытие уведомления cookie",() -> {
                closeCookie.click();
            });
            return this;
        }
        public StartTest openPage(){
            step("Открытие сайта",() -> {
                Selenide.open("/");
            });
            return this;
        }
    }
}

