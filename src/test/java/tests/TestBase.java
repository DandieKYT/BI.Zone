package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;


import java.util.Map;


public class TestBase {
    VkPage vkPage = new VkPage();
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    CareerPage careerPage = new CareerPage();
    HhPage hhPage = new HhPage();
    MaterialsPage materialsPage = new MaterialsPage();
    ParamPage paramPage = new ParamPage();
    Attachments attachment = new Attachments();
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
    }

