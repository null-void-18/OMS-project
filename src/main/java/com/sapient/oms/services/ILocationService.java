package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Location;

public interface ILocationService {
    List<Location> getValue();
    Location save(Location location);
    void delete(Integer id);
}
