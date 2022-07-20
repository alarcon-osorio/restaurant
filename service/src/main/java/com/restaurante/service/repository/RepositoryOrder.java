package com.restaurante.service.repository;

import com.restaurante.service.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryOrder extends JpaRepository<ServiceOrder, Long> {

    @Query(value = "select * from restaurant.service_order WHERE cancel = 0 AND close = 0 ORDER BY table_number", nativeQuery = true)
    List<ServiceOrder> findAll();

    @Query(value = "select * from restaurant.service_order r where r.table_number = ?1 AND cancel = 0 AND close = 0", nativeQuery = true)
    List<ServiceOrder> findByTableNumber(long table);

    @Query(value = "SELECT DISTINCT(table_number) FROM service_order WHERE cancel = 0 AND close = 0", nativeQuery = true)
    List<String> findByDistinctTableNumber();

    @Modifying
    @Query(value = "UPDATE service_order SET ordered = 1 WHERE table_number = ?1", nativeQuery = true)
    void saveOrderTable(long table);

    @Modifying
    @Query(value = "UPDATE service_order SET ordered = 1 WHERE id = ?1", nativeQuery = true)
    void saveOrderTableById(long id);

    @Modifying
    @Query(value = "UPDATE service_order SET served = 1 WHERE id = ?1", nativeQuery = true)
    void saveOrderServed(long id);

    @Modifying
    @Query(value = "UPDATE service_order SET cancel = 1 WHERE id = ?1", nativeQuery = true)
    void orderTableCancel(long id);

    @Modifying
    @Query(value = "UPDATE service_order SET cancel = 1 WHERE table_number = ?1 AND close = 0 AND cancel = 0", nativeQuery = true)
    void cancelOrder(long table);

    @Query(value = "SELECT * FROM service_order WHERE table_number = ?1 AND ordered = 1 AND cancel = 0 AND close = 0", nativeQuery = true)
    List<ServiceOrder> findByNeatOrderByTable(long table);

    @Query(value = "SELECT * FROM service_order WHERE ordered = 1 AND cancel = 0 AND close = 0", nativeQuery = true)
    List<ServiceOrder> findByNeatOrderByTableAll();

    @Query(value = "SELECT * FROM service_order WHERE prepared = 1 AND cancel = 0 AND close = 0", nativeQuery = true)
    List<ServiceOrder> findByPrepared();




}
