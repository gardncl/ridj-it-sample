package ridj.it.sample.repositories;

import org.springframework.data.repository.CrudRepository;
import ridj.it.sample.models.Trip;

public interface Trips extends CrudRepository<Trip, Integer> {

}
