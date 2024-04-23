package com.example.case_study.repository;

import com.example.case_study.entity.Place;
import com.example.case_study.entity.PlaceSearchResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
    List<Place> findByPlaceSearchResponseId(PlaceSearchResponse placeSearchResponse);
}
