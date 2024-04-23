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
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "photo_reference")
    public String photoReference;

    @Column(name = "width")
    public int width;

    @Column(name = "height")
    public int height;

    @Column(name = "html_attribution")
    public String htmlAttribution;
}
