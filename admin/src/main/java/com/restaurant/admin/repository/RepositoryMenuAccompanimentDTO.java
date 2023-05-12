package com.restaurant.admin.repository;

import com.restaurant.admin.dto.MenuAccompanimentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuAccompanimentDTO extends JpaRepository<MenuAccompanimentDTO, Long> {

    @Query(value = "SELECT t1.id, t2.name as menu_type, t3.name as menu, t1.accompaniment FROM restaurant.menu_accompaniment t1 LEFT JOIN restaurant.menu_type t2 ON t1.id_menu_type = t2.id LEFT JOIN restaurant.menu t3 ON t1.id_menu = t3.id ;", nativeQuery = true)
    List<MenuAccompanimentDTO> findAll();


}
