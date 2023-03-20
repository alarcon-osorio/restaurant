package com.restaurant.client.repository;

import com.restaurant.client.entity.Clients;
import com.restaurant.client.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClients extends JpaRepository<Clients, Long> {

    Clients findClientsByEmail(String email);

}
