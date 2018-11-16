package ridj.it.sample.models;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LocationWithTrip {

    private Location location;

    private Set<Integer> tripIds;

    public LocationWithTrip(Location location, Set<Integer> tripIds) {
        this.location = location;
        this.tripIds = tripIds;
    }

    // for json serialization
    public LocationWithTrip() {

    }

    public static LocationWithTrip consumeEntry(Map.Entry<Location, Set<Integer>> entry) {
        return new LocationWithTrip(entry.getKey(), entry.getValue());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Integer> getTripIds() {
        return tripIds;
    }

    public void setTripIds(Set<Integer> tripIds) {
        this.tripIds = tripIds;
    }
}
