package com.restaurant.client.repository;

import com.restaurant.client.entity.MenuOptional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuOptional extends JpaRepository<MenuOptional, Long> {

    @Query(value = "select * from restaurant.menu_optional m where m.id_menu= ?1", nativeQuery = true)
    List<MenuOptional> findByIdMenu(long idMenu);

}
