package com.sapient.oms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.Entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    
}