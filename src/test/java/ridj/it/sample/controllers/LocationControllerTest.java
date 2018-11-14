package ridj.it.sample.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class LocationControllerTest {

    @Spy
    private LocationController locationController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(locationController)
                .build();
    }

    @Test
    public void test() throws Exception {

        MvcResult result = mockMvc.perform(get("/location"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("you see me?", result.getResponse().getContentAsString());
    }

}