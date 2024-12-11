package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Value;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import java.util.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
                                  lastNameInput = $("#lastName"),
                                  emailInput = $("#userEmail"),
                                  genterWrapperInput = $("#genterWrapper"),
                                  numberInput = $("#userNumber"),
                                  calendarInput = $("#dateOfBirthInput"),
                                  subjectsInput = $("#subjectsInput"),
                                  hobbiesWrapperInput = $("#hobbiesWrapper"),
                                  uploadPictureInput = $("#uploadPicture"),
                                  currentAddressInput = $("#currentAddress"),
                                  stateInput = $("#react-select-3-input"),
                                  cityInput = $("#react-select-4-input"),
                                  submitInput = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value){
        genterWrapperInput.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setNumber(String value){
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateofBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
        public RegistrationPage setSubject(String value) {
            subjectsInput.setValue(value).click();

            return this;


    }
        public RegistrationPage setHobbies(String value) {
            hobbiesWrapperInput.$(byText(value)).pressEnter();

            return this;


        }
        public RegistrationPage setPicture(String value) {
            uploadPictureInput.uploadFromClasspath("voin.jpg");

            return this;


        }
        public RegistrationPage setAddress(String value){
            currentAddressInput.setValue(value);

            return this;
        }
    public RegistrationPage setState(String value){
        stateInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setCity(String value){
        cityInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage clickSubmitButton(){
        submitInput.click();

        return this;
    }
    public RegistrationPage verifyRegistrationResultsModalAppears(){
        resultComponent.verifyModalAppears();

        return this;
    }
    public RegistrationPage verifyResult(String key, String value){
        resultComponent.verifyResult(key, value);

        return this;
    }
    public void CheckLineRedColor() {
        numberInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        lastNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        numberInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }







}



