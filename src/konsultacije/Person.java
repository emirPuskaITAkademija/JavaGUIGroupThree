package konsultacije;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String emailAddress;

    public Person(String name, LocalDate birthday, Gender gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return birthday.until(today).getYears();
    }

    @Override
    public String toString() {
        return name + " " + birthday;
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        LocalDate.of(1980, 6, 20),
                        Gender.MALE,
                        "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        LocalDate.of(1990, 7, 15),
                        Gender.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Gender.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Gender.MALE, "bob@example.com"));

        return roster;
    }

}
