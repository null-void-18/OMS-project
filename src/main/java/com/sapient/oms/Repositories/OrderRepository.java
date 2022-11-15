package com.sapient.oms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
