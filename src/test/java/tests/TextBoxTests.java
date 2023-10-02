package tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage.openPage("/automation-practice-form")
                        .executeJS("$('#fixedban').remove()")
                        .executeJS("$('footer').remove()")
                        .setFirstName("Aleksandra")
                        .setLastName("Lak")
                        .setEmail("AleksandraLak@example.com")
                        .setGender("Female")
                        .setUserNumber("9997776655")
                        .setDateOfBirth("20", "May", "1970")
                        .setSubjects("Hindi","Biology")
                        .setHobby("Sports")
                        .setFile("олень.jpeg")
                        .setAddress("My current address")
                        .setState("Haryana")
                        .setCity("Panipat")
                        .clickSubmit()

                        .checkResult("Aleksandra Lak")
                        .checkResult("AleksandraLak@example.com")
                        .checkResult("Female")
                        .checkResult("9997776655")
                        .checkResult("20 May,1970")
                        .checkResult("Hindi, Biology")
                        .checkResult("Sports")
                        .checkResult("олень.jpeg")
                        .checkResult("My current address")
                        .checkResult("Haryana Panipat");
    }
}