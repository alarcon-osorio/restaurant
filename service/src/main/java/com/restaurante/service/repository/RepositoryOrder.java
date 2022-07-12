package com.restaurante.service.repository;

import com.restaurante.service.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOrder extends JpaRepository<ServiceOrder, Long> {
}
