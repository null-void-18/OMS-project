package com.sapient.oms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
