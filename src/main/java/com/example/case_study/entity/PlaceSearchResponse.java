package com.example.case_study.entity;


import com.example.case_study.constant.PlacesSearchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "place_search_response")
public class PlaceSearchResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy = "placeSearchResponseId")
    private List<Place> results;

    @Column(name = "status")
    private String status;
}
