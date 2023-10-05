package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private Faker faker = new Faker();
    private String[] genders = {"Male", "Female", "Other"};
    private String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
    private String[] hobbies = {"Sports", "Reading", "Music"};
    private String[] files = {"олень.jpeg", "цветы.jpeg", "небо.jpeg"};
    private String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    private String[] cityNCR = {"Delhi", "Gutgaon", "Naida"};
    private String[] cityUttarPradesh = {"Agra", "Lucknow", "Merrut"};
    private String[] cityHaryana = {"Karnal", "Panipat"};
    private String[] cityRajasthan = {"Jaipur", "Jaiselmer"};

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return getRandomItemFromArray(genders);
    }

    public String getPhoneNumber() {
        return faker.number().digits(10);
    }

    public String[] getDateOfBirth() {
        return new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH).format(faker.date().birthday(10, 100)).split("/");
    }

    public String getSubject() {
        return getRandomItemFromArray(subjects);
    }

    public String getHobby() {
        return getRandomItemFromArray(hobbies);
    }

    public String getFile() {
        return getRandomItemFromArray(files);
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return getRandomItemFromArray(states);
    }

    public String getCity(String state) {
        if (state == "NCR") {
            return getRandomItemFromArray(cityNCR);
        }
        else if (state == "Uttar Pradesh") {
            return getRandomItemFromArray(cityUttarPradesh);
        }
        else if (state == "Haryana") {
            return getRandomItemFromArray(cityHaryana);
        }
        else
            return getRandomItemFromArray(cityRajasthan);
    }


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }
}
