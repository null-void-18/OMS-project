package com.sapient.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Location;
import com.sapient.oms.services.ILocationService;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired  //dependecny injection
    ILocationService locationService;// never create object
    @GetMapping
    String getStore() {
        return locationService.getValue().toString();
    }

    @PostMapping
    void save(@RequestBody Location location) {
        locationService.save(location);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        locationService.delete(id);
    }
}
