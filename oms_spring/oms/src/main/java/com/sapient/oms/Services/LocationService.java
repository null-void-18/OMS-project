package com.sapient.oms.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.Entity.Location;
import com.sapient.oms.Repositories.LocationRepository;


@Service
public class LocationService implements IService<Location> {
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
    public void save(Location entity) {
        locationRepository.save(entity);
    }

}