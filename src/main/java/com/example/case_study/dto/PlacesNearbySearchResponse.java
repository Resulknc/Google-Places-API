package com.example.case_study.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PlacesNearbySearchResponse {
    public ArrayList<Object> html_attributions;
    public String next_page_token;
    public ArrayList<Place> results;
    public String status;
}

