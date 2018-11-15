package ridj.it.sample.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import ridj.it.sample.models.Trip;
import ridj.it.sample.repositories.Trips;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TripServiceTest {

    @Spy
    @InjectMocks
    private TripService tripService;

    @Mock
    private Trips trips;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void tripExists() {
        int id = 1;
        Trip trip = new Trip(id, "foo", "bar", LocalDate.now());
        when(trips.findById(id))
                .thenReturn(Optional.of(trip));

        int rowsUpdated = tripService.deleteById(id);

        verify(trips, times(1)).deleteById(id);
        assertEquals(1, rowsUpdated);
    }

    @Test
    public void noTripExists() {
        int id = 1;
        when(trips.findById(id))
                .thenReturn(Optional.empty());

        int rowsUpdated = tripService.deleteById(id);

        verify(trips, times(0)).deleteById(id);
        assertEquals(0, rowsUpdated);
    }
}