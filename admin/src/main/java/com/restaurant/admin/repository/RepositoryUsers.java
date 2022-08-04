package com.restaurant.admin.repository;

import com.restaurant.admin.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsers extends JpaRepository<Users, Long> {
}
