package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("Simple")
public class SelectyTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода на страницу о компании")
    @Tag("smoke")
    void conditionsTests() {
        step("Открываем страницу работа ", () -> {
            open("/career");
        });
        step("Нажимаем на контакты", () -> {
            $("a[href*='/contacts']").click();
        });
        step("Проверяем, что на странице содержится заголовок 'Контакты'", () -> {
            $(".heading__title").shouldHave(text("Контакты"));
        });
    }

    @Test
    @DisplayName("Проверка выбора вакансии")
    @Tag("smoke")
    void selectJob(){
        step("Выбираем вакансию", () -> {
            open("/vacancies");
            $("nice-select").click();
            $("list[option selected focus]input").click();
        });

        }
    }


