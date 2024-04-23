package com.example.case_study.repository;

import com.example.case_study.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {
}
