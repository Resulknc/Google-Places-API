package com.example.case_study.service;

import com.example.case_study.dto.ApiCallDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class GoogleApiCall {
    //TODO delete before publish/commit code
    private final String API_KEY = "API_KEY";
    private final String PLACES_API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";

    private final RestTemplate restTemplate;

    public GoogleApiCall(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchNearbyPlaces(ApiCallDto apiCallDto ) {
        //Locale.US to use . instead , for double parameters
        String url = String.format(Locale.US,"%s?location=%f,%f&radius=%d&key=%s",
                PLACES_API_URL, apiCallDto.getLatitude() , apiCallDto.getLongitude(), apiCallDto.getRadius(), API_KEY);
        return restTemplate.getForObject(url, String.class);
    }
}
