package com.example.case_study.dto;

import lombok.Data;

@Data
public class ApiCallDto {
    private double longitude;
    private double latitude;
    private int radius;
}
