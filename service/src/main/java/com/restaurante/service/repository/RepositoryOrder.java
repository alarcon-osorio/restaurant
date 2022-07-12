package com.restaurante.service.repository;

import com.restaurante.service.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryOrder extends JpaRepository<ServiceOrder, Long> {

    @Query(value = "select * from restaurant.service_order ORDER BY table_number", nativeQuery = true)
    List<ServiceOrder> findAll();

    @Query(value = "select * from restaurant.service_order r where r.table_number = ?1", nativeQuery = true)
    List<ServiceOrder> findByTableNumber(long table);

}
