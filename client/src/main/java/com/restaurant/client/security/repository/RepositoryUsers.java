package com.restaurant.client.security.repository;

import com.restaurant.client.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUsers extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

}
