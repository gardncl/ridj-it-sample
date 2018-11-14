package ridj.it.sample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.*;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="trips_id_seq")
    private int id;

    @NotNull
    @Size(max = 40)
    private String name;

    @NotNull
    private String description;

    @NotNull
    private LocalDate date;

}
