package Service;

import java.util.List;

public interface RideService {
    List<String> find_ride(String userName, int[] userLocation, int[] destinationLocation);

    String choose_ride(String userName,String driverName);

    String calculateBill(String userName);

    List<String> totalEarnings();
}
