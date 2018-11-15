package ridj.it.sample.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @RequestMapping(method = RequestMethod.GET)
    public String example() {
        return "you see me?";
    }

}
