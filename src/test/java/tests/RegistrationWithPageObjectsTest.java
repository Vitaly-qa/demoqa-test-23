package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


        @Test
        void successfulRegistrationTest() {
            registrationPage
                    .openPage()
                    .removeBanners()
                    .setFirstName("Vitalik")
                    .setLastName("Kuzmin")
                    .setEmail("avtozp2015@yandex.ru")
                    .setGender("Male")
                    .setNumber("89105138384")
                    .setDateofBirth("08", "July", "1990")
                    .setSubject("Arts")
                    .setHobbies("Reading")
                    .setPicture("voin.jpg")
                    .setAddress("Klin")
                    .setState("NCR")
                    .setCity("Delhi")
                    .clickSubmitButton();

            registrationPage
                    .verifyRegistrationResultsModalAppears()
                    .verifyResult("Student Name", "Vitalik Kuzmin")
                    .verifyResult("Student Email", "avtozp2015@yandex.ru")
                    .verifyResult("Gender", "Male")
                    .verifyResult("Mobile", "8910513838")
                    .verifyResult("Date of Birth", "08 July,1990")
                    .verifyResult("Subjects", "Arts")
                    .verifyResult("Hobbies", "Reading")
                    .verifyResult("Picture", "voin.jpg")
                    .verifyResult("Address", "Klin")
                    .verifyResult("State and City", "NCR Delhi");

        }

        @Test
        void minimalFillFormTest() {

        registrationPage.openPage()
                .setFirstName("Vitalik")
                .setLastName("Kuzmin")
                .setGender("Male")
                .setNumber("8910513838")
                .setDateofBirth("08", "July", "1990")
                .clickSubmitButton();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Vitalik Kuzmin")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8910513838")
                .verifyResult("Date of Birth", "08 July,1990");

        }

        @Test
        void negativeTest() {
             registrationPage
                     .openPage()
                     .setGender("Male")
                     .setNumber("")
                     .setDateofBirth("08", "July", "1990")
                     .setSubject("Arts")
                     .setHobbies("Reading")
                     .setPicture("voin.jpg")
                     .setAddress("Klin")
                     .setState("NCR")
                     .setCity("Delhi")
                     .clickSubmitButton();

            registrationPage.verifyNORegistrationResultsModalAppears();
        }

    }

