package Model;

import java.util.Arrays;
import java.util.Objects;

public class Driver {
    private String name;
    private char gender;
    private int age;
    private String vehicalDetails;
    private int[] location;
    private boolean status;
    private int totalEarnings;

    public Driver(String name, char gender, int age, String vehicalDetails, int[] location,boolean status) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicalDetails = vehicalDetails;
        this.location = location;
        this.status=status;
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

    public String getVehicalDetails() {
        return vehicalDetails;
    }

    public void setVehicalDetails(String vehicalDetails) {
        this.vehicalDetails = vehicalDetails;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }




    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return name.equals(driver.name) && vehicalDetails.equals(driver.vehicalDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vehicalDetails);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", vehicalDetails='" + vehicalDetails + '\'' +
                ", location=" + Arrays.toString(location) +
                ", status=" + status +
                ", totalEarnings=" + totalEarnings +
                '}';
    }
}
