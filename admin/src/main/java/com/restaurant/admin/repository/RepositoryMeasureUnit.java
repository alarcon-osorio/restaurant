package com.restaurant.admin.repository;

import com.restaurant.admin.entity.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMeasureUnit extends JpaRepository<MeasureUnit, Long> {
}
