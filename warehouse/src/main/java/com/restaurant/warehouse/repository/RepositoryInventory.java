package com.restaurant.warehouse.repository;

import com.restaurant.warehouse.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInventory extends JpaRepository<Inventory, Long> {
}
