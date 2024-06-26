package com.example.case_study.repository;

import com.example.case_study.entity.PlaceSearchResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceSearchResponseRepository extends JpaRepository<PlaceSearchResponse,Integer> {

    Optional<PlaceSearchResponse> findPlaceSearchResponseById(int id);
}
