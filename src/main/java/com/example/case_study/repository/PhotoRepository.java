package com.example.case_study.repository;

import com.example.case_study.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo,Integer> {
}
