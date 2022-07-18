package com.restaurant.kitchen.repository;

import com.restaurant.kitchen.entity.MenuAccompaniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMenuAccompaniment extends JpaRepository<MenuAccompaniment, Long> {
}
