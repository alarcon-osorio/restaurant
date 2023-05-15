package com.restaurante.service.repository;


import com.restaurante.service.entity.MenuPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuPersonalView extends JpaRepository<MenuPersonal, Long> {

    @Query(value = "select * from restaurant.menu_personal_view r where r.username = ?1", nativeQuery = true)
    List<MenuPersonal> findByUsername(String username);

    @Query(value = "select * from restaurant.menu_personal_view r where r.id = ?1", nativeQuery = true)
    MenuPersonal findById(long idMenuPersonal);
}
