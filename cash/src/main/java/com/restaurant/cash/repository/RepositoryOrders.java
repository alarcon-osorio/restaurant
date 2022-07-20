package com.restaurant.cash.repository;

import com.restaurant.cash.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryOrders extends JpaRepository<ServiceOrder, Long> {
    @Query(value = "select * from restaurant.service_order r where r.table_number = ?1 AND ordered = 1 AND cancel = 0 AND close = 0 AND served = 1", nativeQuery = true)
    List<ServiceOrder> getServiceOrdersByTable(long table);

    @Query(value = "SELECT DISTINCT(table_number) FROM service_order WHERE ordered = 1 AND cancel = 0 AND close = 0 AND served = 1", nativeQuery = true)
    List<String> findByDistinctTableNumber();

    @Query(value = "SELECT SUM(price * cant) from restaurant.service_order r where r.table_number = ?1 AND ordered = 1 AND cancel = 0 AND close = 0 AND served = 1;", nativeQuery = true)
    String findTotalOrder(long table);

}
