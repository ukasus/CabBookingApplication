package Model;

import java.util.Arrays;
import java.util.Objects;

public class RideQuery {

    private String userName;
    private int[] sourceLocation;
    private int[] destinationLocation;

    public RideQuery(String userName, int[] sourceLocation, int[] destinationLocation) {
        this.userName = userName;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int[] getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(int[] sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public int[] getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(int[] destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideQuery rideQuery = (RideQuery) o;
        return userName.equals(rideQuery.userName) && Arrays.equals(sourceLocation, rideQuery.sourceLocation) && Arrays.equals(destinationLocation, rideQuery.destinationLocation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userName);
        result = 31 * result + Arrays.hashCode(sourceLocation);
        result = 31 * result + Arrays.hashCode(destinationLocation);
        return result;
    }

    @Override
    public String toString() {
        return "RideQuery{" +
                "userName='" + userName + '\'' +
                ", sourceLocation=" + Arrays.toString(sourceLocation) +
                ", destinationLocation=" + Arrays.toString(destinationLocation) +
                '}';
    }
}
