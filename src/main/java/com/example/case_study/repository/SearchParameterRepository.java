package com.example.case_study.repository;

import com.example.case_study.entity.SearchParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchParameterRepository extends JpaRepository<SearchParameter,Integer> {
}
