package com.sapient.oms.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Location;
import com.sapient.oms.repositories.LocationRepository;


@Service
public class LocationService implements ILocationService {
    @Autowired
    LocationRepository locationRepository;

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    @Override
    public List<Location> getValue() {
        return locationRepository.findAll();
    }

    @Override
    public int save(Location entity) {
        locationRepository.save(entity);
        return 1;
    }

}