package Service;

import Model.Driver;
import Model.Ride;
import Model.RideQuery;
import Model.User;
import Repository.DriverRepository;
import Repository.RideRepository;
import Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class RideServiceImpl implements RideService {

    private static int rangeForDriverSearch=5;

    private static int amountPerUnitDistanceOfRide=6;

    private UserRepository userRepository=UserRepository.getInstance();
    private DriverRepository driverRepository=DriverRepository.getInstance();
    private RideRepository rideRepository=RideRepository.getInstance();

    private UserService userService=new UserServiceImpl();
    private DriverService driverService=new DriverServiceImpl();




    @Override
    public List<String> find_ride(String userName, int[] userLocation, int[] destinationLocation) {
         try {
            List<Driver> drivers = driverRepository.getDrivers();
             List<String> driverNames=new ArrayList<>();

            for(Driver driver:drivers)
            {
                if (driver.getStatus()) {
                    int[] driverLocation = driver.getLocation();
                    int x = (int) Math.abs(userLocation[0] - driverLocation[0]);
                    x = x * x;

                    int y = (int) Math.abs(userLocation[1] - driverLocation[1]);
                    y = y * y;

                    int distance = (int) Math.sqrt(x + y);
                  //  System.out.println(distance);
                    if (distance <= rangeForDriverSearch)
                        driverNames.add(driver.getName());

                }
            }


            RideQuery rideQuery = new RideQuery(userName, userLocation, destinationLocation);
            if (!rideRepository.getRideQueries().contains(rideQuery))
                rideRepository.getRideQueries().add(rideQuery);


           // List<Driver> driversAvailable = drivers.stream().filter(distanceCheck).collect(Collectors.toList());

            //List<String> driverNames = driversAvailable.stream().map(e -> e.getName()).collect(Collectors.toList());
            return driverNames;
        }
        catch (Exception e)
        {
            System.out.println("Find Ride failed. Try again");
        }
         return new ArrayList<>();
    }

    @Override
    public String choose_ride(String userName, String driverName) {
        try{
            User user = userRepository.getUser(userName);
            Driver driver = driverRepository.getDriver(driverName);
            RideQuery rideQuery = rideRepository.getRideQuery(userName);

            Ride ride = new Ride(userName, driverName, rideQuery.getSourceLocation(), rideQuery.getDestinationLocation());

            rideRepository.addRide(ride);

            userService.upate_userLocation(userName, rideQuery.getDestinationLocation());
            driverService.update_driverLocation(driverName, rideQuery.getDestinationLocation());
            driverService.change_driver_status(driverName, false);

            rideRepository.removeRideQuery(rideQuery);


            return "Ride Started";
        }
        catch (Exception e) {
            return "Ride start failed .Try again";
        }
    }

    @Override
    public String calculateBill(String userName) {

        try{
            Ride ride = rideRepository.getRide(userName);

            int[] source = ride.getStartLocation();
            int[] destination = ride.getDestinationLocation();

            int x = (int) Math.abs(source[0] - destination[0]);
            x = x * x;

            int y = (int) Math.abs(source[1] - destination[1]);
            y = y * y;

            int distance = (int) Math.sqrt(x + y);

            int amount = distance * amountPerUnitDistanceOfRide;
            ride.setBill(amount);
            driverService.change_driver_status(ride.getDriverName(), true);

            Driver driver = driverRepository.getDriver(ride.getDriverName());
            driver.setTotalEarnings(driver.getTotalEarnings() + amount);


            rideRepository.removeRide(ride);
            return "Ride Ended bill amount: "+amount;
        }
        catch (Exception e)
        {
            return "Failed to generate bill try again.";
        }




    }

    @Override
    public List<String> totalEarnings() {
        List<String> ans=new ArrayList<>();

        List<Driver> drivers=driverRepository.getDrivers();

        for(Driver d:drivers)
        {
            String s= d.getName()+" earns: "+d.getTotalEarnings();
            ans.add(s);
        }
        return ans;
    }


}
