package com.example.case_study.controller;

import com.example.case_study.dto.ApiCallDto;
import com.example.case_study.service.GoogleApiCall;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rest APIs for GoogleApiCall Operations")
@RestController
@RequestMapping("/apicall")
public class GoogleApiCallController {

    private GoogleApiCall googleApiCall;

    @Autowired
    public GoogleApiCallController(GoogleApiCall googleApiCall){
        this.googleApiCall=googleApiCall;
    }

    @PostMapping("/apicall")
    public ResponseEntity<String> gettAllapicall(@RequestBody ApiCallDto apiCallDto) {

        return ResponseEntity.ok(googleApiCall.searchNearbyPlaces(apiCallDto));
    }
}
