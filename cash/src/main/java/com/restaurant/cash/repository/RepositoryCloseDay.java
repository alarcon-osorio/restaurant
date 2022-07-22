package com.restaurant.cash.repository;

import com.restaurant.cash.dto.CloseDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCloseDay extends JpaRepository<CloseDay, String> {

    @Query(value = "SELECT id, name, cant, table_number,  CAST(time AS DATE) as time,  price * cant as total_item, payment_method FROM restaurant.service_order where  CAST(time AS DATE) =  CURRENT_DATE() AND close = 1;", nativeQuery = true)
    List<CloseDay> findCloseDay();

    @Query(value = "SELECT sum(cant * price) as total FROM restaurant.service_order where  CAST(time AS DATE) =  CURRENT_DATE() AND close = 1;", nativeQuery = true)
    String findTotalOrder();
}
