package Service;

import Model.Driver;
import Repository.DriverRepository;

public class DriverServiceImpl implements DriverService{

    private DriverRepository driverRepository=DriverRepository.getInstance();

    @Override
    public boolean addDriver(Driver driver) {
        if(driverRepository.getDrivers().contains(driver)) {
            System.out.println("Can't add duplicate Driver");
            return false;
        }
        else {
            driverRepository.add(driver);
            return true;
        }

    }

    @Override
    public boolean update_driverLocation(String driverName,int[] location) {
        Driver driver=driverRepository.getDriver(driverName);
        if(driver!=null)
            driver.setLocation(location);

        return driver==null?false:true;
    }

    @Override
    public boolean change_driver_status(String driverName, boolean status) {
        Driver driver=driverRepository.getDriver(driverName);
        if(driver!=null) {
           driver.setStatus(status);
           return true;
        }
        return false;
    }
}
