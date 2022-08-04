package com.restaurant.admin.repository;

import com.restaurant.admin.entity.MenuAccompaniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuAccompaniment extends JpaRepository<MenuAccompaniment, Long> {
    @Query(value = "select * from restaurant.menu_accompaniment m where m.id_menu= ?1", nativeQuery = true)
    List<MenuAccompaniment> findByMenuId(long id);

    @Query(value = "SELECT DISTINCT(accompaniment) FROM menu_accompaniment;", nativeQuery = true)
    List<String> findAccompanimentDistinct();


}
