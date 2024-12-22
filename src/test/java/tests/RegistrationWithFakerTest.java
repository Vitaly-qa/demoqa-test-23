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
                .setFirstName(testDataGenerator.getFirstName())
                .setLastName(testDataGenerator.getLastName())
                .setEmail(testDataGenerator.getUserEmail())
                .setGender(testDataGenerator.getUserGender())
                .setNumber(testDataGenerator.getUserNumber())
                .setDateOfBirth(testDataGenerator.getDayOfBirth(), testDataGenerator.getMonthOfBirth(), testDataGenerator.getYearOfBirth())
                .setSubject(testDataGenerator.getSubject())
                .setHobbies(testDataGenerator.getHobbies())
                .setPicture(testDataGenerator.getPictures())
                .setAddress(testDataGenerator.getCurrentAddress())
                .setState(testDataGenerator.getRandomState())
                .setCity(testDataGenerator.getRandomCity())
                .clickSubmitButton();

        registrationPage
                .verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", testDataGenerator.getFirstName())
                .verifyResult("Student Email", testDataGenerator.getUserEmail())
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", testDataGenerator.getUserNumber())
                .verifyResult("Date of Birth", testDataGenerator.getDayOfBirth()
                        + " "
                        + testDataGenerator.getMonthOfBirth()
                        + ","
                        + testDataGenerator.getYearOfBirth())
                .verifyResult("Subjects", testDataGenerator.getSubject())
                .verifyResult("Hobbies", testDataGenerator.getHobbies())
                .verifyResult("Picture", testDataGenerator.getPictures())
                .verifyResult("Address", testDataGenerator.getCurrentAddress())
                .verifyResult("State and City", testDataGenerator.getRandomState() + " " + testDataGenerator.getRandomCity());

    }

    @Test
    void minimalFillFormTest() {

        registrationPage.openPage()
                .setFirstName(testDataGenerator.getFirstName())
                .setLastName(testDataGenerator.getLastName())
                .setGender(testDataGenerator.getUserGender())
                .setNumber(testDataGenerator.getUserNumber())
                .setDateOfBirth(testDataGenerator.getDayOfBirth(), testDataGenerator.getMonthOfBirth(), testDataGenerator.getYearOfBirth())
                .clickSubmitButton();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", testDataGenerator.getFirstName())
                .verifyResult("Gender", testDataGenerator.getUserGender())
                .verifyResult("Mobile", testDataGenerator.getUserNumber())
                .verifyResult("Date of Birth", testDataGenerator.getDayOfBirth() + " " + testDataGenerator.getMonthOfBirth() + "," + testDataGenerator.getYearOfBirth());

    }

    @Test
    void negativeTest() {
        registrationPage
                .openPage()
                .setGender(testDataGenerator.getUserGender())
                .setNumber("")
                .setDateOfBirth(testDataGenerator.getDayOfBirth(), testDataGenerator.getMonthOfBirth(), testDataGenerator.getYearOfBirth())
                .setSubject(testDataGenerator.getSubject())
                .setHobbies(testDataGenerator.getHobbies())
                .setPicture(testDataGenerator.getPictures())
                .setAddress(testDataGenerator.getCurrentAddress())
                .setState(testDataGenerator.getRandomState())
                .setCity(testDataGenerator.getRandomCity())
                .clickSubmitButton();

        registrationPage.verifyNoRegistrationResultsModalAppears();
    }

}