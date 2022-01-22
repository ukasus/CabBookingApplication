package Driver;

import Model.User;
import Service.*;

import java.io.IOException;
import java.util.List;


public class Driver {

    private static UserService userService=new UserServiceImpl();
    private static DriverService driverService=new DriverServiceImpl();
    private static RideService rideService=new RideServiceImpl();

    public static void main(String[] args) throws IOException {

        userService.add_user(new User("Abhishek",'M',23));
        userService.upate_userLocation("Abhishek", new int[]{0, 0});

        userService.add_user(new User("Rahul",'M',29));
        userService.upate_userLocation("Rahul", new int[]{10, 0});

        userService.add_user(new User("Nandini",'F',22));
        userService.upate_userLocation("Nandini", new int[]{15, 6});

//        List<User> users=UserRepository.getInstance().getUsers();
//        users.stream().forEach(user -> System.out.println(user));


        driverService.addDriver(new Model.Driver("Driver1",'M',22,"Swift, KA-01-12345",new int[]{10,1},true));
        driverService.addDriver(new Model.Driver("Driver2",'M',29,"Swift, KA-01-12345",new int[]{11,10},true));
        driverService.addDriver(new Model.Driver("Driver3",'M',24,"Swift, KA-01-12345",new int[]{5,3},true));


//        DriverRepository.getInstance().getDrivers().stream().forEach(driver -> System.out.println(driver));

        List<String> driversName=rideService.find_ride("Rahul",new int[]{10,0},new int[]{20,1});
        driversName.stream().forEach(e->System.out.println(e));

        System.out.println(rideService.choose_ride("Rahul","Driver3"));

        System.out.println(rideService.calculateBill("Rahul"));



//        DriverRepository.getInstance().getDrivers().stream().forEach(driver -> System.out.println(driver));
//        List<User> users=UserRepository.getInstance().getUsers();
//        users.stream().forEach(user -> System.out.println(user));


        System.out.println(rideService.totalEarnings());











    }












}
