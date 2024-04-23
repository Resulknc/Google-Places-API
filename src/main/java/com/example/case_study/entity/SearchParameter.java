package com.example.case_study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "searchparameters")
public class SearchParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "radius")
    private String radius;

    @OneToOne
    @JoinColumn(name = "plac_search_response_id", referencedColumnName = "id", nullable = false)
    private PlaceSearchResponse placeSearchResponse;
}
