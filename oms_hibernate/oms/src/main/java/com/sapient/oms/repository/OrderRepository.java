package com.sapient.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sapient.oms.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM order WHERE user_id = ?1", nativeQuery = true)

    List<Order> findAllByUserOrderByCreatedDateDesc(Integer userId);

}
