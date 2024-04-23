package com.example.case_study.repository;

import com.example.case_study.entity.Northeast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NortheastRepository extends JpaRepository<Northeast,Integer> {
}
