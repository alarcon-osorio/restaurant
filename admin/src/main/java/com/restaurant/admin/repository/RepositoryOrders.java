package com.restaurant.admin.repository;

import com.restaurant.admin.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryOrders extends JpaRepository<ServiceOrder, Long> {


    @Query(value = "select * from restaurant.service_order r where close = 1 AND cancel = 0", nativeQuery = true)
    List<ServiceOrder> findOrders();

    @Query(value = "SELECT SUM(price * cant) from restaurant.service_order r where close = 1 AND cancel = 0", nativeQuery = true)
    String findTotalOrders();

    @Query(value = "SELECT count(*) FROM service_order WHERE cancel=0 AND close = 1;", nativeQuery = true)
    String findTotalAttend();

    @Query(value = "SELECT count(*) FROM service_order WHERE prepared = 1 AND served = 0 AND cancel = 0 AND close = 0;", nativeQuery = true)
    String findPendingAttend();

    @Query(value = "SELECT count(*) FROM service_order WHERE cancel = 1", nativeQuery = true)
    String findCancelled();





}
