package com.payload.payloaduser;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

// This is optional class, could use as a back up for later.
@Service
public class GeolocationService {

    private static final String GEOLOCATION_API_URL = "http://ip-api.com/json/";

    private final RestTemplate restTemplate;

    public GeolocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, String>getGeolocation(String ipAddress) {
        String apiUrl = GEOLOCATION_API_URL + ipAddress;
        return restTemplate.getForObject(apiUrl, Map.class);
    }
}
