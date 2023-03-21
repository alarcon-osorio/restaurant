package com.restaurant.client.repository;

import com.restaurant.client.security.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClients extends JpaRepository<Clients, Long> {

    Clients findClientByEmail(String email);

}
