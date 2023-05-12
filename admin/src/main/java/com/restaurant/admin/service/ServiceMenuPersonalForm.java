package com.restaurant.admin.service;

import com.restaurant.admin.dto.MenuPersonalFormDTO;
import com.restaurant.admin.entity.MenuPersonalForm;
import com.restaurant.admin.repository.RepositoryMenuPersonalForm;
import com.restaurant.admin.repository.RepositoryMenuPersonalFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuPersonalForm {

    @Autowired
    RepositoryMenuPersonalForm repositoryMenuPersonalForm;

    @Autowired
    RepositoryMenuPersonalFormDTO repositoryMenuPersonalFormDTO;

    public List<MenuPersonalForm> getMenuPersonalForm(){
        return repositoryMenuPersonalForm.findAll();
    }

    public List<MenuPersonalFormDTO> getMenuPersonalFormDTO(){
        return repositoryMenuPersonalFormDTO.findMenuPersonalFormDTO();
    }

    public List<MenuPersonalForm> getMenuPersonalFormByType(long type){
        return repositoryMenuPersonalForm.findMenuPersonalFormByType(type);
    }

    public MenuPersonalForm getMenuPersonalById(long id){
        return repositoryMenuPersonalForm.findByNameId(id);
    }

    public void saveMenuPersonalForm(MenuPersonalForm menuPersonalForm){
        repositoryMenuPersonalForm.save(menuPersonalForm);
    }

    public void deleteMenuPersonalForm(long id){
        repositoryMenuPersonalForm.deleteById(id);
    }


}
