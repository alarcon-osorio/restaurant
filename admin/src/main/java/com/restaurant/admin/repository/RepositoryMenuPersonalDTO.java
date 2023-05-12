package com.restaurant.admin.repository;


import com.restaurant.admin.dto.MenuPersonalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuPersonalDTO extends JpaRepository<MenuPersonalDTO, Long> {

    @Query(value = "select t1.time, t1.id, t1.username, t1.id_menu_type, t1.name_dish, t1.observations, t2.name as options, t3.name as principles, t4.name as proteins, t5.name as entries, t6.name as vegetables, t7.name as salad, t8.name as drinks from menu_personal_view t1 left join menu_personal_form t2 on t1.options = t2.id left join menu_personal_form t3 on t1.principles = t3.id left join menu_personal_form t4 on t1.proteins = t4.id left join menu_personal_form t5 on t1.entries = t5.id left join menu_personal_form t6 on t1.vegetables = t6.id left join menu_personal_form t7 on t1.salad = t7.id left join menu_personal_form t8 on t1.drinks = t8.id where t1.username = ?1", nativeQuery = true)
    List<MenuPersonalDTO> findByPersonalFormAndUsername(String username);

    @Query(value = "SELECT t1.id, t1.username, t2.name as id_menu_type, t1.name_dish, t3.name as options, t4.name as principles, t5.name as proteins, t6.name as entries, t7.name as vegetables, t8.name as salad, t9.name as drinks, t1.observations, t1.time FROM menu_personal_view t1 LEFT JOIN menu_type t2 ON t1.id_menu_type = t2.id LEFT JOIN menu_personal_form t3 ON t1.options = t3.id LEFT JOIN menu_personal_form t4 ON t1.principles = t4.id LEFT JOIN menu_personal_form t5 ON t1.proteins = t5.id LEFT JOIN menu_personal_form t6 ON t1.entries = t6.id LEFT JOIN menu_personal_form t7 ON t1.vegetables = t7.id LEFT JOIN menu_personal_form t8 ON t1.salad = t8.id LEFT JOIN menu_personal_form t9 ON t1.drinks = t9.id;", nativeQuery = true)
    List<MenuPersonalDTO> findByPersonalMenuDTO();
}
