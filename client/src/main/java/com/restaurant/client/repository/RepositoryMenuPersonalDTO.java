package com.restaurant.client.repository;

import com.restaurant.client.dto.MenuPersonalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuPersonalDTO extends JpaRepository<MenuPersonalDTO, Long> {

    @Query(value = "select t1.time, t1.id, t1.username, t1.id_menu_type, t1.name_dish, t1.observations, t2.name as options, t3.name as principles, t4.name as proteins, t5.name as entries, t6.name as vegetables, t7.name as salad, t8.name as drinks from menu_personal_view t1 left join menu_personal_form t2 on t1.options = t2.id left join menu_personal_form t3 on t1.principles = t3.id left join menu_personal_form t4 on t1.proteins = t4.id left join menu_personal_form t5 on t1.entries = t5.id left join menu_personal_form t6 on t1.vegetables = t6.id left join menu_personal_form t7 on t1.salad = t7.id left join menu_personal_form t8 on t1.drinks = t8.id where t1.username = ?1", nativeQuery = true)
    List<MenuPersonalDTO> findByPersonalFormAndUsername(String username);
}
