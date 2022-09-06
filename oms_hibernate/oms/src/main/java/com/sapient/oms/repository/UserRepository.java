package com.sapient.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.entity.Address;
import com.sapient.oms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    void save(Address address);

}
