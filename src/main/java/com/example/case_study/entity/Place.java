package com.example.case_study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "vicinity")
    private String vicinity;

    @Column(name = "types")
    private ArrayList<String> types;

    @OneToOne
    @JoinColumn(name = "geometry_id", referencedColumnName = "id", nullable = false)
    private Geometry geometry;

    @Column(name = "rating")
    private double rating;

    @Column(name = "icon")
    private String icon;

    @Column(name = "reference")
    private String reference;

    @Column(name = "place_id")
    private String place_id;

    @Column(name = "scope")
    private String scope;

    @Column(name = "business_status")
    private String business_status;

    @Column(name = "icon_background_color")
    private String icon_background_color;

    @Column(name = "icon_mask_base_uri")
    private String icon_mask_base_uri;

    @Column(name = "user_ratings_total")
    private int user_ratings_total;

    @ManyToOne
    @JoinColumn(name = "place_search_response_id", referencedColumnName = "id", nullable = false)
    private PlaceSearchResponse placeSearchResponseId;
}
