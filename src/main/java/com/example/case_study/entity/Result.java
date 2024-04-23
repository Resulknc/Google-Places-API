package com.example.case_study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "vicinity")
    private String vicinity;

    @OneToMany(mappedBy = "id")
    private List<Type> type;

    @OneToOne
    @JoinColumn(name = "geometry_id", referencedColumnName = "id", nullable = false)
    private Geometry geometry;

    @Column(name = "rating")
    private double rating;

    @Column(name = "icon")
    private String icon;

    @Column(name = "reference")
    private String reference;

    @OneToOne
    @JoinColumn(name = "opening_hours_id", referencedColumnName = "id", nullable = false)
    private OpeningHours openingHours;

    @OneToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id", nullable = false)
    private Photo photo;

    @Column(name = "price_level")
    private int price_level;

    @Column(name = "user_ratings_total")
    private int userRatingsTotal;

    @Column(name = "place_id")
    private String placeId;

    @Column(name = "scope")
    private String scope;

    @OneToOne
    @JoinColumn(name = "plus_code_id", referencedColumnName = "id", nullable = false)
    private PlusCode plusCode;

    @Column(name = "icon_background_color")
    private String iconBackgroundColor;

    @Column(name = "business_status")
    private String businessStatus;

    @Column(name = "icon_mask_base_uri")
    private String iconMaskBaseUri;
}
