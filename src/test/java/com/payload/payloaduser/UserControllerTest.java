package com.payload.payloaduser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.boot.test.web.servlet.MockMvc;
import org.springframework.boot.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.web.servlet.result.MockMvcresultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeolocationService geolocationService;

    @Test
    public void testRegisterUser ValidPayload() throws Exception {

        // Mock the geolocation service response
        Map<String, String>geolocationResponse = new HashMap<>();
        geolocationResponse.put("country", "Canada");
        geolocationResponse.put("city", "Toronto");
        when(geolocationService.getGeolocation("192.168.1.1")).thenReturn(geolocationResponse);

        // Prepare the JSON payload
        String payload =
                "{\"username\":\"user\",\"password\":\"P@sswOrd\",\"ipAddress\":\"192.168.1.1\"}";


        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .content(payload)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(mockMvcResultMatchers.content().string("Welcome, user!\nUUID:<generated uuid>\nCity: Toronto"));


    }
}
