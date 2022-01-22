package Service;

import Model.Driver;

public interface DriverService {

    boolean addDriver(Driver driver);

    boolean update_driverLocation(String driverNam,int[] location);

    boolean change_driver_status(String driverName,boolean status);

}
