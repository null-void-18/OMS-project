package com.sapient.oms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.InventoryId;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, InventoryId>{
    List<Inventory> findByIdStoreId(int storeId);
    Optional<Inventory> findById(InventoryId id);
}
