package com.restaurant.client.service;

import com.restaurant.client.entity.menu_personal.MenuPersonalForm;
import com.restaurant.client.repository.RepositoryMenuPersonalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuPersonalForm {

    @Autowired
    RepositoryMenuPersonalForm repositoryMenuForm;

    public List<MenuPersonalForm> getMenuPersonalForm(){
        return repositoryMenuForm.findAll();
    }

    public List<MenuPersonalForm> getMenuPersonalFormByType(long type){
        return repositoryMenuForm.findMenuPersonalFormByType(type);
    }

}
