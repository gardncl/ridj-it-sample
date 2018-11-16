package ridj.it.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ridj.it.sample.models.Trip;
import ridj.it.sample.repositories.Trips;
import ridj.it.sample.services.TripService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private Trips trip;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteId(@PathVariable(value = "id") int id) {
        int rowsUpdated = tripService.deleteById(id);
        switch (rowsUpdated) {
            case 1:
                return new ResponseEntity(HttpStatus.ACCEPTED);
            case 0:
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Trip trip) {
        int rowsUpdated = tripService.update(trip);
        switch (rowsUpdated) {
            case 1:
                return new ResponseEntity(HttpStatus.ACCEPTED);
            case 0:
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Trip> getById(@PathVariable(value = "id") int id) {
        Optional<Trip> tripOptional = tripService.getById(id);
        if (tripOptional.isPresent()) {
            return new ResponseEntity<>(tripOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
