package com.restaurant.admin.repository;

import com.restaurant.admin.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryInventory extends JpaRepository<Inventory, Long> {

    @Query(value = "SELECT id, number_product,name, type, status, measure_unit, price_unit, date_price_unit, sale_price, date_sale_price, cant_disp, cant_order, cant_min_inv, date, price_unit * cant_disp as total_inventory FROM warehouse;", nativeQuery = true)
    List<Inventory> findAll();

    @Query(value = "SELECT MAX(number_product) FROM warehouse WHERE number_product LIKE CONCAT('%',:numberProduct,'%')", nativeQuery = true)
    String findNumberProduct(@Param("numberProduct") String numberProduct);

}
