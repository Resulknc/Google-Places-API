package com.example.case_study.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Place {
    public String name;
    public String vicinity;
    public ArrayList<String> types;
    public Geometry geometry;
    public double rating;
    public String icon;
    public String reference;
    public String place_id;
    public String scope;
    public String business_status;
    public String icon_background_color;
    public String icon_mask_base_uri;
    public int user_ratings_total;
}
