package ridj.it.sample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ridj.it.sample.models.Trip;
import ridj.it.sample.repositories.Trips;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private Trips trips;

    @Transactional
    public int deleteById(Integer id) {
        Optional<Trip> trip = trips.findById(id);
        if (trip.isPresent()) {
            trips.deleteById(id);
            return 1;
        } else {
            return 0;
        }
    }

    @Transactional
    public int update(Trip updatedTrip) {
        Optional<Trip> existingTrip =
                trips.findById(updatedTrip.getId());
        if (existingTrip.isPresent()) {
            trips.save(updatedTrip);
            return 1;
        } else {
            return 0;
        }
    }

    public Optional<Trip> getById(int id) {
        return trips.findById(id);
    }

}
