package com.restaurant.admin.repository;

import com.restaurant.admin.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRestaurantTable extends JpaRepository<RestaurantTable, Long> {
}
