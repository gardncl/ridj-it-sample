package ridj.it.sample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ridj.it.sample.models.Location;
import ridj.it.sample.models.LocationWithTrip;
import ridj.it.sample.models.Trip;
import ridj.it.sample.repositories.Locations;
import ridj.it.sample.repositories.Trips;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private Locations locations;

    @Autowired
    private Trips trips;

    public List<LocationWithTrip> findAllWithTrips() {
        List<Trip> tripList = new ArrayList<>();
        trips.findAll().forEach(tripList::add);

        HashMap<Integer, LocationWithTrip> map = new HashMap<>();

        for (Trip trip : tripList) {
            Location location = trip.getLocation();
            //STRANGE THING WHERE FOREIGN KEY DOESN'T SHOW UP TWICE SO THIS IS INCORRECT
            if (location != null) {
                if (map.containsKey(location.getId())) {
                    LocationWithTrip locationWithTrip = map.get(location.getId());
                    locationWithTrip.getTripIds().add(trip.getId());
                    map.put(location.getId(), locationWithTrip);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(trip.getId());
                    map.put(location.getId(), new LocationWithTrip(location, set));
                }
            }
        }

        return map.keySet().stream().map(map::get).collect(Collectors.toList());
    }

}
