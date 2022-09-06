package com.sapient.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}
