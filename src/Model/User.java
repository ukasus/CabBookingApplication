package Model;

import java.util.Arrays;
import java.util.Objects;

public class User {

    private String name;
    private char gender;
    private int age;
    private int[] location;


    private int contactNumber;

    public User(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }
    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return gender == user.gender && age == user.age && contactNumber == user.contactNumber && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, contactNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", location=" + Arrays.toString(location) +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
