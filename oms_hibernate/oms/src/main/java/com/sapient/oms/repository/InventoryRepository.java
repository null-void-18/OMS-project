package com.sapient.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.InventoryKey;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, InventoryKey> {

    @Query(value = "SELECT * FROM inventory WHERE Store_id = ?1", nativeQuery = true)
    List<Inventory> find(int id);

    @Query(value = "SELECT * FROM inventory WHERE product_id = ?1", nativeQuery = true)
    Inventory findByProduct(int productId);

    @Query(value = "SELECT * FROM Inventory  WHERE store_id = ?1 and product_id = ?2", nativeQuery = true)
    Inventory findInventory(Integer storeid, Integer productid);

    @Modifying
    @Query(value = "DELETE i from Inventory i WHERE product_id = ?1", nativeQuery = true)
    int deleteByProduct(Integer productId);
}
