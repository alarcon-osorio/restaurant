package com.restaurant.client.security.repository;

import com.restaurant.client.security.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryClientSecurity extends JpaRepository<Clients, Long> {

    Clients findByUsername(String username);

    @Query(value = "select * from restaurant.clients r where r.username LIKE %?1%", nativeQuery = true)
    Clients findLikeUsername(String username);

    @Query(value = "select * from restaurant.clients r where r.username LIKE %?1%", nativeQuery = true)
    List<Clients> findLikeUsernameList(String username);

}
