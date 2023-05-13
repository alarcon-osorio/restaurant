package com.restaurant.admin.repository;

import com.restaurant.admin.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryInventory extends JpaRepository<Inventory, Long> {
    @Query(value = "SELECT t1.description, t1.id, t1.number_product,t1.name, t1.status, t3.type as measure_unit, t2.type as type, t1.price_unit, t1.date_price_unit, t1.sale_price, t1.date_sale_price, t1.cant_disp, t1.cant_order, t1.cant_min_inv, t1.date, t1.price_unit * t1.cant_disp as total_inventory FROM warehouse t1 LEFT JOIN warehouse_type_product t2 ON t1.type LEFT JOIN measure_unit t3 ON t1.measure_unit = t3.id;", nativeQuery = true)
    List<Inventory> findAll();

    @Query(value = "SELECT MAX(number_product) FROM warehouse WHERE number_product LIKE CONCAT('%',:numberProduct,'%')", nativeQuery = true)
    String findNumberProduct(@Param("numberProduct") String numberProduct);

}
