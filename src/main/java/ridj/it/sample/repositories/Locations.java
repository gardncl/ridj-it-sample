package ridj.it.sample.repositories;

import org.springframework.data.repository.CrudRepository;
import ridj.it.sample.models.Location;

public interface Locations extends CrudRepository<Location, Integer> {

}
