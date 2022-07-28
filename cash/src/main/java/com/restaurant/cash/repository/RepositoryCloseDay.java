package com.restaurant.cash.repository;

import com.restaurant.cash.dto.CloseDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCloseDay extends JpaRepository<CloseDay, String> {

    @Query(value = "SELECT id, name, cant, table_number, time, CASE WHEN discount > 0 THEN (cant * price) - (cant * price * discount / 100) ELSE (price * cant) END as total_item, discount, payment_method FROM restaurant.service_order where CAST(time AS DATE) = CURRENT_DATE() AND close = 1", nativeQuery = true)
    List<CloseDay> findCloseDay();

    @Query(value = "SELECT id, name, cant, table_number, time, CASE WHEN discount > 0 THEN (cant * price) - (cant * price * discount / 100) ELSE (price * cant) END as total_item, discount, payment_method FROM restaurant.service_order where CAST(time AS DATE) = ?1 AND close = 1", nativeQuery = true)
    List<CloseDay> findCloseDayByDate(String date);

    @Query(value = "SELECT sum((cant * price) - (cant * price * discount / 100)) as total FROM restaurant.service_order where CAST(time AS DATE) =  CURRENT_DATE() AND close = 1;", nativeQuery = true)
    String findTotalOrder();

    @Query(value = "SELECT sum((cant * price) - (cant * price * discount / 100)) as total FROM restaurant.service_order where CAST(time AS DATE) =  ?1 AND close = 1;", nativeQuery = true)
    String findTotalOrderByDate(String date);
}
