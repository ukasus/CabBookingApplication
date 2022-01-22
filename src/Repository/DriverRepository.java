package Repository;

import Model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriverRepository {
    private static List<Driver> drivers;

    private static DriverRepository driverRepository=null;

    private DriverRepository(){
        drivers=new ArrayList<>();
    }


    public static DriverRepository getInstance()
    {
        if(driverRepository==null)
            driverRepository=new DriverRepository();

        return driverRepository;
    }


    public List<Driver> getDrivers(){
        return drivers;
    }

    public Driver getDriver(String driverName) {

        List<Driver> driver=drivers.stream().filter(e->

                e.getName().equals(driverName)

        ).collect(Collectors.toList());

        return driver.get(0);
    }

    public Driver add(Driver driver){
        drivers.add(driver);
        return driver;
    }

}
