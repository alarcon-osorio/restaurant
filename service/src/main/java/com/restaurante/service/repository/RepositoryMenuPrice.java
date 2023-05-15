package com.restaurante.service.repository;

import com.restaurante.service.entity.MenuPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMenuPrice extends JpaRepository<MenuPrice, Long> {
}
