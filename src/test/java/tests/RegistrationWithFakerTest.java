package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestDataGenerator;

public class RegistrationWithFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataGenerator testDataGenerator = new TestDataGenerator();

    @Test
    void successfulRegistrationTest() {

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(testDataGenerator.firstName)
                .setLastName(testDataGenerator.lastName)
                .setEmail(testDataGenerator.userEmail)
                .setGender(testDataGenerator.userGender)
                .setNumber(testDataGenerator.userNumber)
                .setDateOfBirth(testDataGenerator.dayOfBirth, testDataGenerator.monthOfBirth, testDataGenerator.yearOfBirth)
                .setSubject(testDataGenerator.subject)
                .setHobbies(testDataGenerator.hobbies)
                .setPicture(testDataGenerator.pictures)
                .setAddress(testDataGenerator.currentAddress)
                .setState(testDataGenerator.randomState)
                .setCity(testDataGenerator.randomCity)
                .clickSubmitButton();

        registrationPage
                .verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", testDataGenerator.firstName)
                .verifyResult("Student Email", testDataGenerator.userEmail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", testDataGenerator.userNumber)
                .verifyResult("Date of Birth", testDataGenerator.dayOfBirth
                        + " "
                        + testDataGenerator.monthOfBirth
                        + ","
                        + testDataGenerator.yearOfBirth)
                .verifyResult("Subjects", testDataGenerator.subject)
                .verifyResult("Hobbies", testDataGenerator.hobbies)
                .verifyResult("Picture", testDataGenerator.pictures)
                .verifyResult("Address", testDataGenerator.currentAddress)
                .verifyResult("State and City", testDataGenerator.randomState + " " + testDataGenerator.randomCity);

    }

    @Test
    void minimalFillFormTest() {

        registrationPage.openPage()
                .setFirstName(testDataGenerator.firstName)
                .setLastName(testDataGenerator.lastName)
                .setGender(testDataGenerator.userGender)
                .setNumber(testDataGenerator.userNumber)
                .setDateOfBirth(testDataGenerator.dayOfBirth, testDataGenerator.monthOfBirth, testDataGenerator.yearOfBirth)
                .clickSubmitButton();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", testDataGenerator.firstName)
                .verifyResult("Gender", testDataGenerator.userGender)
                .verifyResult("Mobile", testDataGenerator.userNumber)
                .verifyResult("Date of Birth", testDataGenerator.dayOfBirth + " " + testDataGenerator.monthOfBirth + "," + testDataGenerator.yearOfBirth);

    }

    @Test
    void negativeTest() {
        registrationPage
                .openPage()
                .setGender(testDataGenerator.userGender)
                .setNumber("")
                .setDateOfBirth(testDataGenerator.dayOfBirth, testDataGenerator.monthOfBirth, testDataGenerator.yearOfBirth)
                .setSubject(testDataGenerator.subject)
                .setHobbies(testDataGenerator.hobbies)
                .setPicture(testDataGenerator.pictures)
                .setAddress(testDataGenerator.currentAddress)
                .setState(testDataGenerator.randomState)
                .setCity(testDataGenerator.randomCity)
                .clickSubmitButton();

        registrationPage.verifyNoRegistrationResultsModalAppears();
    }

}