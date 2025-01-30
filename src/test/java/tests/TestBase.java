package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void setUpBrowserConfiguration() {
        String getWdHost = format("https://user1:1234@%s/wd/hub", System.getProperty("wd", "selenoid.autotests.cloud"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "125.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.pageLoadStrategy = System.getProperty("loadStrategy", "eager");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.remote = getWdHost;
        Configuration.browserCapabilities = capabilities;
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        if (!System.getProperty("browser").equalsIgnoreCase("firefox")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        Selenide.closeWebDriver();
        Attach.addVideo();
    }
}
