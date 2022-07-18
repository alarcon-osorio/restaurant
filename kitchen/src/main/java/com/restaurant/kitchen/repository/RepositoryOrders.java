package com.restaurant.kitchen.repository;

import com.restaurant.kitchen.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOrders extends JpaRepository<ServiceOrder, Long>{
}
