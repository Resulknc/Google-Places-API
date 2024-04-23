package com.example.case_study.repository;

import com.example.case_study.entity.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeometryRepository extends JpaRepository<Geometry,Integer> {
}
