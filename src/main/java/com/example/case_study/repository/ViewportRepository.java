package com.example.case_study.repository;

import com.example.case_study.entity.Viewport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewportRepository extends JpaRepository<Viewport,Integer> {
}
