package com.restaurant.admin.repository;


import com.restaurant.admin.dto.MenuPersonalFormDTO;
import com.restaurant.admin.entity.MenuPersonalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuPersonalFormDTO extends JpaRepository<MenuPersonalFormDTO, Long> {

    @Query(value = "SELECT t1.id, t1.name, CASE WHEN t2.name = 'options' THEN 'Cereal' WHEN t2.name = 'principles' THEN 'Principios' WHEN t2.name = 'proteins' THEN 'Proteinas' WHEN t2.name = 'entries' THEN 'Entradas' WHEN t2.name = 'vegetables' THEN 'Vegetales' WHEN t2.name = 'salad' THEN 'Ensaladas' WHEN t2.name = 'drinks' THEN 'Bebidas' END as type FROM menu_personal_form t1 LEFT JOIN menu_personal_type t2 ON t1.type = t2.id ORDER BY t2.name;", nativeQuery = true)
    List<MenuPersonalFormDTO> findMenuPersonalFormDTO();


}
