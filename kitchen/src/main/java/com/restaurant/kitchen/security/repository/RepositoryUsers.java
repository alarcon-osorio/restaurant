package com.restaurant.kitchen.security.repository;

import com.restaurant.kitchen.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsers extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

}
