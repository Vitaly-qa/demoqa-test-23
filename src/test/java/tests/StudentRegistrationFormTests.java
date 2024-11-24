package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.Click;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1928x1980";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

        @Test

        void fillFormTests() {
            open("https://demoqa.com/automation-practice-form");
            $("#firstName").setValue("Vitalik");
            $("#lastName").setValue("Kuzmin");
            $("#userEmail").setValue("avtozp2015@yandex.ru");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("88888888");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("1990");
            $(".react-datepicker__day.react-datepicker__day--008").click();
            $("#subjectsContainer").click();
            $("#subjectsInput").setValue("Arts").pressEnter();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            File file = $("#uploadPicture").uploadFile(new File("src/test/resources/voin.jpg"));
            $("#currentAddress").setValue("Klin");
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            $("#submit").click();


        }
    }

