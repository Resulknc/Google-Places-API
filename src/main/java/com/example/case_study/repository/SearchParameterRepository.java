package com.example.case_study.repository;

import com.example.case_study.entity.SearchParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SearchParameterRepository extends JpaRepository<SearchParameter,Long> {

    Optional<SearchParameter> findByLongitudeAndLatitudeAndRadius(String longitude, String latitude, String radius);
}
