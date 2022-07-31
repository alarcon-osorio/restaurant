package com.restaurant.warehouse.repository;

import com.restaurant.warehouse.entity.WarehouseTypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryWarehouseTypeProduct extends JpaRepository<WarehouseTypeProduct, Long> {
}
