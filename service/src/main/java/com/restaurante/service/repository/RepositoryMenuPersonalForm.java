package com.restaurante.service.repository;

import com.restaurante.service.entity.MenuPersonalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMenuPersonalForm extends JpaRepository<MenuPersonalForm, Long> {

    @Query(value = "select * from restaurant.menu_personal_form r where r.type = ?1", nativeQuery = true)
    List<MenuPersonalForm> findMenuPersonalFormByType(long type);

    @Query(value = "select * from restaurant.menu_personal_form r where r.id = ?1", nativeQuery = true)
    MenuPersonalForm findByNameId(String id);

}
