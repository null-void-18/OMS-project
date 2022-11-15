package com.sapient.oms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    
}
