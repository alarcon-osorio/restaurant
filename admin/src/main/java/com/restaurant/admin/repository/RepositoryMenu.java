package com.restaurant.admin.repository;

import com.restaurant.admin.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenu extends JpaRepository<Menu, Long> {

    @Query(value = "select * from restaurant.menu r where r.id_menu_type = ?1", nativeQuery = true)
    List<Menu> findbyMenuTypeId(long id);

}
