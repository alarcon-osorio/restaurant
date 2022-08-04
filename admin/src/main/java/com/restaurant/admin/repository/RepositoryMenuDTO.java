package com.restaurant.admin.repository;

import com.restaurant.admin.dto.MenuDTO;
import com.restaurant.admin.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuDTO extends JpaRepository<MenuDTO, Long> {

    @Autowired
    @Query(value = "select m.id, mt.name as menu_type, m.name, m.description, m.price, m.image, m.ordered from restaurant.menu m left join restaurant.menu_type mt ON m.id_menu_type = mt.id", nativeQuery = true)
    List<MenuDTO> findAll();

}
