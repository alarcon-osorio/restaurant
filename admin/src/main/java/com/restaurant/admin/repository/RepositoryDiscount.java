package com.restaurant.admin.repository;

import com.restaurant.admin.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDiscount extends JpaRepository<Discount, Long> {
}
