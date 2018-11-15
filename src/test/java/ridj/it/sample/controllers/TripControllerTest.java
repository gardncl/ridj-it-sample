package ridj.it.sample.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ridj.it.sample.services.TripService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

        mockMvc.perform(delete("/trip/"+id))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    public void tripDoesNotExist() throws Exception {
        int id = 1;
        int rowsUpdated = 0;
        when(tripService.deleteById(id))
                .thenReturn(rowsUpdated);

        mockMvc.perform(delete("/trip/"+id))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}