package com.restaurant.admin.repository;

import com.restaurant.admin.entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryModules extends JpaRepository<Modules, Long> {
}
