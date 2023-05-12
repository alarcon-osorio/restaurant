package com.restaurant.admin.repository;

import com.restaurant.admin.dto.MenuPersonalFormDTO;
import com.restaurant.admin.entity.MenuPersonalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuPersonalType extends JpaRepository<MenuPersonalType, Long> {

    @Query(value = "SELECT id, CASE WHEN name = 'options' THEN 'Cereal' WHEN name = 'principles' THEN 'Principios' WHEN name = 'proteins' THEN 'Proteinas' WHEN name = 'entries' THEN 'Entradas' WHEN name = 'vegetables' THEN 'Vegetales' WHEN name = 'salad' THEN 'Ensaladas' WHEN name = 'drinks' THEN 'Bebidas' END as name FROM menu_personal_type;", nativeQuery = true)
    List<MenuPersonalType> findMenuPersonalType();



}
