package com.restaurante.service.repository;

import com.restaurante.service.entity.MenuAccompaniment;
import com.restaurante.service.entity.MenuIncludes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuIncludes extends JpaRepository<MenuIncludes, Long> {

    @Query(value = "select * from restaurant.menu_includes m where m.id_menu= ?1", nativeQuery = true)
    List<MenuIncludes> findByIdMenu(long id);

}
