package com.restaurante.service.repository;

import com.restaurante.service.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRestaurantTable extends JpaRepository<RestaurantTable, Long> {
}
