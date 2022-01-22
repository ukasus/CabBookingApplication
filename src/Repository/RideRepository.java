package Repository;

import Model.Ride;
import Model.RideQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RideRepository {


    private static List<Ride> rides;
    private static List<RideQuery> rideQueries;

    private static RideRepository rideRepository=null;

    private RideRepository(){
        rides=new ArrayList<>();
        rideQueries=new ArrayList<>();
    }


    public List<RideQuery> getRideQueries() {
        return rideQueries;
    }



    public static RideRepository getInstance()
    {
        if(rideRepository==null)
            rideRepository=new RideRepository();

        return rideRepository;
    }


    public List<Ride> getRides(){
        return rides;
    }

    public void addRideQuery(RideQuery rideQuery)
    {
        rideQueries.add(rideQuery);
    }

    public void addRide(Ride ride)
    {
        rides.add(ride);
    }

    public RideQuery getRideQuery(String userName) {

        List<RideQuery> queries=rideQueries.stream().filter(e->

                e.getUserName().equals(userName)

        ).collect(Collectors.toList());

        return queries.get(0);
    }

    public void removeRideQuery(RideQuery rideQuery)
    {
        rideQueries.remove(rideQuery);
    }
    public void removeRide(Ride ride)
    {
        rides.remove(ride);
    }

    public Ride getRide(String userName) {

        List<Ride> ride=rides.stream().filter(e->

                e.getUserName().equals(userName)

        ).collect(Collectors.toList());

        return ride.get(0);
    }




}
