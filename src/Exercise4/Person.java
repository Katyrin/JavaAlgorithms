package Exercise4;

import java.util.ArrayList;

public class Person {
    private String name;
    private Long phoneNumbers;
    private String emailAddresses;

    public Person(String name, Long phoneNumbers, String emailAddresses) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
    }

    public String getSurname() {
        return name;
    }

    public Long getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmailAddresses() {
        return emailAddresses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emailAddresses='" + emailAddresses + '\'' +
                '}';
    }
}