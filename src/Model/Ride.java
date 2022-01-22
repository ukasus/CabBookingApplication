package Model;

import java.util.Arrays;
import java.util.Objects;

public class Ride {

    private String userName;
    private String driverName;
    private int[] startLocation;
    private int[] destinationLocation;
    private int bill;


    public Ride(String userName, String driverName, int[] startLocation, int[] destinationLocation) {
        this.userName = userName;
        this.driverName = driverName;
        this.startLocation = startLocation;
        this.destinationLocation = destinationLocation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int[] getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(int[] startLocation) {
        this.startLocation = startLocation;
    }

    public int[] getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(int[] destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return userName.equals(ride.userName) && driverName.equals(ride.driverName) && Arrays.equals(startLocation, ride.startLocation) && Arrays.equals(destinationLocation, ride.destinationLocation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userName, driverName);
        result = 31 * result + Arrays.hashCode(startLocation);
        result = 31 * result + Arrays.hashCode(destinationLocation);
        return result;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "userName='" + userName + '\'' +
                ", driverName='" + driverName + '\'' +
                ", startLocation=" + Arrays.toString(startLocation) +
                ", destinationLocation=" + Arrays.toString(destinationLocation) +
                ", bill=" + bill +
                '}';
    }
}
