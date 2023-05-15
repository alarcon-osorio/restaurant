package com.restaurante.service.service;


import com.restaurante.service.entity.MenuPersonalForm;
import com.restaurante.service.repository.RepositoryMenuPersonalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuPersonalForm {

    @Autowired
    RepositoryMenuPersonalForm repositoryMenuPersonalForm;

    public List<MenuPersonalForm> getMenuPersonalForm(){
        return repositoryMenuPersonalForm.findAll();
    }

    public List<MenuPersonalForm> getMenuPersonalFormByType(long type){
        return repositoryMenuPersonalForm.findMenuPersonalFormByType(type);
    }

    public MenuPersonalForm getMenuPersonalById(String id){
        return repositoryMenuPersonalForm.findByNameId(id);
    }



}
