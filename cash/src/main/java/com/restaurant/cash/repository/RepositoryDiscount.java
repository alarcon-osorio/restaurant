package com.restaurant.cash.repository;

import com.restaurant.cash.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDiscount extends JpaRepository<Discount, Long> {
}
