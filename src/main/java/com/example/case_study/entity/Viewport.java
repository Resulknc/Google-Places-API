package com.example.case_study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viewports")
public class Viewport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "southwest_id", referencedColumnName = "id", nullable = false)
    private Southwest southwest;

    @OneToOne
    @JoinColumn(name = "northeast_id", referencedColumnName = "id", nullable = false)
    private Northeast northeast;

}
