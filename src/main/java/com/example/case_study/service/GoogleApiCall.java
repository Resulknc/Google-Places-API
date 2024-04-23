package com.example.case_study.service;

import com.example.case_study.dto.Place;
import com.example.case_study.dto.PlacesNearbySearchResponse;
import com.example.case_study.entity.*;
import com.example.case_study.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class GoogleApiCall {
    //TODO delete before publish/commit code
    private final String API_KEY = "API_KEY";
    private final String PLACES_API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";

    @Autowired
    private SearchParameterRepository searchParameterRepository;
    @Autowired
    private PlaceSearchResponseRepository placeSearchResponseRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private MapperService mapperService;

    private final RestTemplate restTemplate;
    ModelMapper modelMapper;

    public GoogleApiCall(RestTemplate restTemplate, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    public PlacesNearbySearchResponse searchNearbyPlaces(double longitude, double latitude, int radius) {

        PlacesNearbySearchResponse placesNearbySearchResponse;
//        PlaceSearchResponse placeSearchResponse;
        SearchParameter searchParameter = searchParameterRepository.findByLongitudeAndLatitudeAndRadius(String.valueOf(longitude),String.valueOf(latitude),String.valueOf(radius)).orElse(null);

        if (searchParameter != null) {

            PlaceSearchResponse placeSearchResponse = placeSearchResponseRepository.findPlaceSearchResponseById(searchParameter.getPlaceSearchResponse().getId()).orElse(null);

            placesNearbySearchResponse = modelMapper.map(placeSearchResponse, PlacesNearbySearchResponse.class);

        } else {
            //Locale.US to use "." instead "," for double parameters
            String url = String.format(Locale.US, "%s?location=%f,%f&radius=%d&key=%s",
                    PLACES_API_URL, latitude, longitude, radius, API_KEY);

            placesNearbySearchResponse = restTemplate.getForObject(url, PlacesNearbySearchResponse.class);


            PlaceSearchResponse placeSearchResponse = modelMapper.map(placesNearbySearchResponse, PlaceSearchResponse.class);
            placeSearchResponseRepository.save(placeSearchResponse);

            for (Place place : placesNearbySearchResponse.results) {
                com.example.case_study.entity.Place place1 = mapperService.mapPlace(place);
                place1.setPlaceSearchResponseId(placeSearchResponse);
                placeRepository.save(place1);
            }

            searchParameter = new SearchParameter();
            searchParameter.setPlaceSearchResponse(placeSearchResponse);
            searchParameter.setLatitude(String.valueOf(latitude));
            searchParameter.setRadius(String.valueOf(radius));
            searchParameter.setLongitude(String.valueOf(longitude));
            searchParameterRepository.save(searchParameter);
        }

        return placesNearbySearchResponse;

    }


}
