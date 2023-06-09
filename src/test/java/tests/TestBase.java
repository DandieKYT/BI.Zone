package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import steps.BiZoneSteps;


public class TestBase {
    BiZoneSteps biZoneSteps = new BiZoneSteps();
    @BeforeAll
    static void setUp() {
    Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://bi.zone";
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "100.0";

//        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities = capabilities;
    }
        @AfterEach
        void attachemts(){
            biZoneSteps.browserLogs();
            biZoneSteps.attachScreenshot();
            biZoneSteps.pageSource();
            biZoneSteps.addVideo();
        }
    }

