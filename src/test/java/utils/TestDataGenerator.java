package utils;


import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;
public class TestDataGenerator {

    private String firstName;
    private String lastName;
    private String userEmail;
    private String userGender;
    private String userNumber;
    private String monthOfBirth;
    private String subject;
    private String hobbies;
    private String pictures;
    private String currentAddress;
    private String randomState;
    private String randomCity;
    private int yearOfBirth;
    private int dayOfBirth;

        Faker faker = new Faker();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getPictures() {
        return pictures;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getRandomState() {
        return randomState;
    }

    public String getRandomCity() {
        return randomCity;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public TestDataGenerator () {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            userEmail = faker.internet().emailAddress();
            userGender = faker.options().option(GENDER);
            userNumber = "89" + faker.phoneNumber().subscriberNumber(8);
            monthOfBirth = faker.options().option(MONTHS);
            yearOfBirth = faker.number().numberBetween(1901, 2023);
            dayOfBirth = generateValidDay(monthOfBirth, yearOfBirth);
            subject = faker.options().option(SUBJECTS);
            hobbies = faker.options().option(HOBBY_OPTIONS);
            pictures = faker.options().option(MORE_PICTURES);
            currentAddress = faker.address().streetAddress();
            randomState = faker.options().option(STATE_CITIES.keySet().toArray(new String[0]));
            randomCity = getRandomCity(randomState);
        }

        public static String[] MONTHS = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        public static String[] SUBJECTS = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"};

        public static String[] HOBBY_OPTIONS = {"Reading", "Sports", "Music"};

        public static String[] GENDER = {"Male", "Female", "Other"};

        public static String[] MORE_PICTURES = {"voin.jpg", "sun.jpg"};

        private static final Map<String, String[]> STATE_CITIES = Map.of(
                "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
                "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
                "Haryana", new String[]{"Karnal", "Panipat"},
                "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
        );

        private static String getRandomCity(String state) {
            String[] cities = STATE_CITIES.get(state);

            return new Faker().options().option(cities);
        }

        private static int getDaysInMonth(String month, int year) {
            Map<String, Integer> monthDays = new HashMap<>();
            monthDays.put("January", 31);
            monthDays.put("February", isLeapYear(year) ? 29 : 28);
            monthDays.put("March", 31);
            monthDays.put("April", 30);
            monthDays.put("May", 31);
            monthDays.put("June", 30);
            monthDays.put("July", 31);
            monthDays.put("August", 31);
            monthDays.put("September", 30);
            monthDays.put("October", 31);
            monthDays.put("November", 30);
            monthDays.put("December", 31);

            return monthDays.getOrDefault(month, 0);
        }

        private static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        private int generateValidDay(String month, int year) {
            int daysInMonth = getDaysInMonth(month, year);
            return faker.number().numberBetween(1, daysInMonth + 1);
        }

}
