package com.restaurant.client.repository;

import com.restaurant.client.entity.Menu;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenu extends JpaRepository<Menu, Long> {

    @Query(value = "select * from restaurant.menu r where r.id_menu_type = ?1", nativeQuery = true)
    List<Menu> findbyMenuTypeId(long id);

}
