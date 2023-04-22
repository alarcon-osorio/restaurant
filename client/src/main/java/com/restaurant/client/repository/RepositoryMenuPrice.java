package com.restaurant.client.repository;

import com.restaurant.client.entity.MenuPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMenuPrice extends JpaRepository<MenuPrice, Long> {
}
