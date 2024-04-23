package com.example.case_study.controller;

import com.example.case_study.dto.PlacesNearbySearchResponse;
import com.example.case_study.service.GoogleApiCall;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Rest APIs for GoogleApiCall Operations")
@RestController
@RequestMapping("/apicall")
public class GoogleApiCallController {

    private GoogleApiCall googleApiCall;

    @Autowired
    public GoogleApiCallController(GoogleApiCall googleApiCall){
        this.googleApiCall=googleApiCall;
    }

    @GetMapping("/apicall")
    public ResponseEntity<PlacesNearbySearchResponse> gettAllapicall(@RequestParam double longitude, @RequestParam double latitude, @RequestParam int radius) {

        return ResponseEntity.ok(googleApiCall.searchNearbyPlaces(longitude,latitude,radius));
    }
}
