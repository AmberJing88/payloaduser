package com.payload.payloaduser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Validated
public class UserController {


    private final GeolocationService geolocationService;

    @Autowired
    public UserController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }


    @PostMapping("/register")
    public ResponseEntity<String>registerUser(@Validated @RequestBody UserPayload payload) {

        // call the IP-API.com Geolocation API
        String geolocationUrl = "http://ip-api.com/json/" + payload.getIpAddress();
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Make the API call
            Map<String, String>response = restTemplate.getForObject(geolocationUrl, HashMap.class);

            // check if the IP is in Canada
            String country = response.get("country");
            if(!"Canada".equalsIgnoreCase(country)) {
                return new ResponseEntity<>("User is not eligible to register", HttpStatus.BAD_REQUEST);
            }

            // Generate a random UUID
            String uuid = UUID.randomUUID().toString();

            // construct the welcome message
            String city = response.get("city");
            String welcomeMessage = "Welcome, " + payload.getUsername() + "!\n";
            welcomeMessage += "UUID: " + uuid + "\n";
            welcomeMessage += "City: " + city;

            return new ResponseEntity<>(welcomeMessage, HttpStatus.OK);

        } catch (Exception e) {
            // handle exception

            return new ResponseEntity<>("Error retrieving geolocation",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
