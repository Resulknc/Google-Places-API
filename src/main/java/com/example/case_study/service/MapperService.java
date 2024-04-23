package com.example.case_study.service;

import com.example.case_study.dto.Place;
import com.example.case_study.entity.*;
import com.example.case_study.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    @Autowired
    private GeometryRepository geometryRepository;
    @Autowired
    private ViewportRepository viewportRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private SouthwestRepository southwestRepository;
    @Autowired
    private NortheastRepository northeastRepository;

    ModelMapper modelMapper;

    @Autowired
    public MapperService(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public com.example.case_study.entity.Place mapPlace(Place place) {
        com.example.case_study.entity.Place place1 = modelMapper.map(place, com.example.case_study.entity.Place.class);
        place1.setGeometry(mapGeometry(place.getGeometry()));
        return place1;
    }


    public Geometry mapGeometry(com.example.case_study.dto.Geometry geometry) {
        Geometry geometry1 = new Geometry();
        geometry1.setLocation(mapLocation(geometry.getLocation()));
        geometry1.setViewport(mapViewport(geometry.getViewport()));
        return geometryRepository.save(geometry1);
    }

    public Viewport mapViewport(com.example.case_study.dto.Viewport viewport) {
        Viewport viewport1 = new Viewport();
        viewport1.setNortheast(mapNortheast(viewport.getNortheast()));
        viewport1.setSouthwest(mapSouthwest(viewport.getSouthwest()));
        return viewportRepository.save(viewport1);
    }

    public Southwest mapSouthwest(com.example.case_study.dto.Southwest southwest) {
        Southwest southwest1 = modelMapper.map(southwest, Southwest.class);
        return southwestRepository.save(southwest1);
    }

    public Northeast mapNortheast(com.example.case_study.dto.Northeast northeast) {
        Northeast northeast1 = modelMapper.map(northeast, Northeast.class);
        return northeastRepository.save(northeast1);

    }

    public Location mapLocation(com.example.case_study.dto.Location location) {
        Location location1 = modelMapper.map(location, Location.class);
        return locationRepository.save(location1);
    }
}
