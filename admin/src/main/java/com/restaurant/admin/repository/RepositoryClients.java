package com.restaurant.admin.repository;

import com.restaurant.admin.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClients extends JpaRepository<Clients, Long> {
}
