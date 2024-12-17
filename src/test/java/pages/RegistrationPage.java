package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitInput = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(int day, String month, int year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapperInput.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();


        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitInput.click();

        return this;
    }

    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultComponent.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        resultComponent.verifyResult(key, value);

        return this;
    }
    public RegistrationPage verifyNoRegistrationResultsModalAppears() {
        resultComponent.verifyNoDialogAppears();

        return this;
    }

}



