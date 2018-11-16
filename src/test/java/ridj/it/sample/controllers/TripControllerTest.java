package ridj.it.sample.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ridj.it.sample.models.Trip;
import ridj.it.sample.services.TripService;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TripControllerTest {

    @Spy
    @InjectMocks
    private TripController tripController;

    @Mock
    private TripService tripService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(tripController)
                .build();
    }

    @Test
    public void tripExistsAndIsDeleted() throws Exception {
        int id = 1;
        int rowsUpdated = 1;
        when(tripService.deleteById(id))
                .thenReturn(rowsUpdated);

        mockMvc.perform(delete("/trip/" + id))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    public void tripDoesNotExistDeleteFails() throws Exception {
        int id = 1;
        int rowsUpdated = 0;
        when(tripService.deleteById(id))
                .thenReturn(rowsUpdated);

        mockMvc.perform(delete("/trip/" + id))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void tripExistsAndIsUpdated() throws Exception {
        int rowsUpdated = 1;
        String json = "{\"id\" : 1, \"name\" : \"Moriah Trip\", \"description\" : \"Lets get out into wilderness\", \"date\" : \"2018-11-17\"}";
        when(tripService.update(any(Trip.class)))
                .thenReturn(rowsUpdated);

        mockMvc.perform(
                put("/trip")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    public void tripDoesNotExistUpdateFails() throws Exception {
        int rowsUpdated = 0;
        String json = "{\"id\" : 1, \"name\" : \"Moriah Trip\", \"description\" : \"Lets get out into wilderness\", \"date\" : \"2018-11-17\"}";
        when(tripService.update(any(Trip.class)))
                .thenReturn(rowsUpdated);

        mockMvc.perform(
                put("/trip")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}