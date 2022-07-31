package com.restaurant.warehouse.repository;

import com.restaurant.warehouse.entity.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMeasureUnit extends JpaRepository<MeasureUnit, Long> {
}
