package ridj.it.sample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_id_seq")
    private int id;

    @NotNull
    @Size(max = 40)
    private String name;

    @NotNull
    @Size(max = 100)
    private String address;

    @NotNull
    @Size(max = 30)
    private String city;

    @NotNull
    @Size(max = 2)
    private String state;

    public Location(int id, @NotNull @Size(max = 40) String name, @NotNull @Size(max = 100) String address, @NotNull @Size(max = 30) String city, @NotNull @Size(max = 2) String state) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Location() {
    }
}
