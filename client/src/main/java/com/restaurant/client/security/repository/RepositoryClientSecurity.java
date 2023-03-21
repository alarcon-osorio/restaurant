package com.restaurant.client.security.repository;

import com.restaurant.client.security.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryClientSecurity extends JpaRepository<Clients, Long> {

    Clients findByUsername(String username);
}
