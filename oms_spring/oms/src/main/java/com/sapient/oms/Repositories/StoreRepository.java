package com.sapient.oms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.sapient.oms.Entity.Store;


@Repository
@EnableJpaRepositories
public interface StoreRepository extends JpaRepository<Store, Integer> {
    
}