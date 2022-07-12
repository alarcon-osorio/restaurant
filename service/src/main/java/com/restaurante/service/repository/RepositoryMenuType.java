package com.restaurante.service.repository;

import com.restaurante.service.entity.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMenuType extends JpaRepository<MenuType, Long> {
}
