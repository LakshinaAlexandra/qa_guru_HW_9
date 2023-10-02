package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderInput = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    subjectsInput = $("#subjectsInput"),
                    hobbyInput = $("#hobbiesWrapper"),
                    fileInput = $("#uploadPicture"),
                    addressInput = $("#currentAddress"),
                    stateInput = $("#state"),
                    cityInput = $("#city"),
                    submitButton = $("#submit"),
                    result = $(".modal-content");

    public RegistrationPage openPage(String value){
        open(value);
        return this;
    }

    public RegistrationPage executeJS(String value) {
        executeJavaScript(value);
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
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value1, String value2){
        subjectsInput.setValue(value1).pressEnter();
        subjectsInput.setValue(value2).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value){
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setFile(String value){
        fileInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResult(String value) {
        result.shouldHave(text(value));
        return this;
    }
}