package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class TextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        RandomUtils randomUtils = new RandomUtils();
        String[] birthDate = randomUtils.getDateOfBirth();

        String firstName = randomUtils.getFirstName(),
                lastName = randomUtils.getLastName(),
                email = randomUtils.getEmail(),
                gender = randomUtils.getGender(),
                phoneNumber = randomUtils.getPhoneNumber(),
                birthDay = birthDate[0],
                birthMonth = birthDate[1],
                birthYear = birthDate[2],
                subject_1 = randomUtils.getSubject(),
                subject_2 = randomUtils.getSubject(),
                hobby = randomUtils.getHobby(),
                file = randomUtils.getFile(),
                address = randomUtils.getAddress(),
                state = randomUtils.getState(),
                city = randomUtils.getCity(state);

        registrationPage.openPage("/automation-practice-form")
                        .executeJS("$('#fixedban').remove()")
                        .executeJS("$('footer').remove()")

                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setGender(gender)
                        .setUserNumber(phoneNumber)
                        .setDateOfBirth(birthDay,birthMonth,birthYear)
                        .setSubjects(subject_1,subject_2)
                        .setHobby(hobby)
                        .setFile(file)
                        .setAddress(address)
                        .setState(state)
                        .setCity(city)
                
                        .clickSubmit()

                        .checkResult(firstName + " " + lastName)
                        .checkResult(email)
                        .checkResult(gender)
                        .checkResult(phoneNumber)
                        .checkResult(birthDay + " " + birthMonth + "," + birthYear)
                        .checkResult( subject_1 + "," + " " + subject_2)
                        .checkResult(hobby)
                        .checkResult(file)
                        .checkResult(address)
                        .checkResult(state + " " + city);
    }
}