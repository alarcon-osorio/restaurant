package com.restaurant.admin.repository;

import com.restaurant.admin.entity.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMenuType extends JpaRepository<MenuType, Long> {
}
