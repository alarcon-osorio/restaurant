package com.restaurant.kitchen.repository;

import com.restaurant.kitchen.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryOrders extends JpaRepository<ServiceOrder, Long>{

    @Query(value = "select * from restaurant.service_order ORDER BY table_number", nativeQuery = true)
    List<ServiceOrder> findAll();

    @Query(value = "SELECT DISTINCT(table_number) FROM service_order", nativeQuery = true)
    List<String> findByDistinctTableNumber();

    @Query(value = "select * from restaurant.service_order r where r.table_number = ?1", nativeQuery = true)
    List<ServiceOrder> findByTableNumber(long table);
}
