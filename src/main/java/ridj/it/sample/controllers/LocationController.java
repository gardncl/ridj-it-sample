package ridj.it.sample.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ridj.it.sample.models.Location;
import ridj.it.sample.models.LocationWithTrip;
import ridj.it.sample.services.LocationService;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<LocationWithTrip> findAll() {
        List<LocationWithTrip> list = locationService.findAllWithTrips();

        return list;
    }

}
