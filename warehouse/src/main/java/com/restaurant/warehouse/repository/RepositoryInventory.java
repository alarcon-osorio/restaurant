package com.restaurant.warehouse.repository;

import com.restaurant.warehouse.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryInventory extends JpaRepository<Inventory, Long> {
    @Query(value = "SELECT id, number_product,name, description, status, measure_unit, price_unit, date_price_unit, sale_price, date_sale_price, cant_disp, cant_order, cant_min_inv, date, price_unit * cant_disp as total_inventory FROM warehouse;", nativeQuery = true)
    List<Inventory> findAll();
}
