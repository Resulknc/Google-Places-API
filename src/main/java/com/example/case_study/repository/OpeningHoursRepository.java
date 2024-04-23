package com.example.case_study.repository;

import com.example.case_study.entity.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours,Integer> {
}
