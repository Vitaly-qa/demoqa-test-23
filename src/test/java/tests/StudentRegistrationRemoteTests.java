package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;


public class StudentRegistrationRemoteTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @Test
    @Tag("smoke")
    void fillFormTests() {
        step("Открыть форму", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Заполнение формы", () -> {
            $("#firstName").setValue("Vitalik");
            $("#lastName").setValue("Kuzmin");
            $("#userEmail").setValue("avtozp2015@yandex.ru");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("89105138384");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("1990");
            $(".react-datepicker__day.react-datepicker__day--008").click();
            $("#subjectsContainer").click();
            $("#subjectsInput").setValue("Arts").pressEnter();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#uploadPicture").uploadFromClasspath("voin.jpg");
            $("#currentAddress").setValue("Klin");
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            $("#submit").click();
        });
        step("Верный результат", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table").shouldHave(text("Student Name")).shouldHave(text("Vitalik Kuzmin"));
            $(".table").shouldHave(text("Student Email")).shouldHave(text("avtozp2015@yandex.ru"));
            $(".table").shouldHave(text("Gender")).shouldHave(text("Male"));
            $(".table").shouldHave(text("Mobile")).shouldHave(text("8910513838"));
            $(".table").shouldHave(text("Date of Birth")).shouldHave(text("08 July,1990"));
            $(".table").shouldHave(text("Subjects")).shouldHave(text("Arts"));
            $(".table").shouldHave(text("Hobbies")).shouldHave(text("Reading"));
            $(".table").shouldHave(text("Picture")).shouldHave(text("voin.jpg"));
            $(".table").shouldHave(text("Address")).shouldHave(text("Klin"));
            $(".table").shouldHave(text("State and City")).shouldHave(text("NCR Delhi"));
        });


    }

}


