package com.restaurant.admin.repository;

import com.restaurant.admin.dto.MenuOptionalDTO;
import com.restaurant.admin.entity.MenuOptional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuOptionalDTO extends JpaRepository<MenuOptionalDTO, Long> {

    @Query(value = "SELECT t1.id, t2.name as menu_type, t3.name as menu, t1.option1, t1.option2, t1.option3, t1.option4, t1.option5 FROM restaurant.menu_optional t1 LEFT JOIN restaurant.menu_type t2 ON t1.id_menu_type = t2.id LEFT JOIN restaurant.menu t3 ON t1.id_menu = t3.id ;", nativeQuery = true)
    List<MenuOptionalDTO> findAll();

}
