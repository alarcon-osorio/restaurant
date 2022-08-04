package com.restaurant.admin.repository;

import com.restaurant.admin.dto.MenuIncludesDTO;
import com.restaurant.admin.entity.MenuIncludes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuIncludesDTO extends JpaRepository<MenuIncludesDTO, Long> {

    @Query(value = "SELECT t1.id, t2.name as menu_type, t3.name as menu, t1.name, t1.price FROM restaurant.menu_includes t1 LEFT JOIN restaurant.menu_type t2 ON t1.id_menu_type = t2.id LEFT JOIN restaurant.menu t3 ON t1.id_menu = t3.id ;", nativeQuery = true)
    List<MenuIncludesDTO> findAll();

}
