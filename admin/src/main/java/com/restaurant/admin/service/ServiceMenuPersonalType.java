package com.restaurant.admin.service;


import com.restaurant.admin.dto.MenuPersonalTypeDTO;
import com.restaurant.admin.entity.MenuPersonalType;
import com.restaurant.admin.repository.RepositoryMenuPersonalType;
import com.restaurant.admin.repository.RepositoryMenuPersonalTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuPersonalType {

    @Autowired
    RepositoryMenuPersonalType repositoryMenuPersonalType;

    @Autowired
    RepositoryMenuPersonalTypeDTO repositoryMenuPersonalTypeDTO;

    public List<MenuPersonalType> getMenuType(){
        return repositoryMenuPersonalType.findMenuPersonalType();
    }

    public MenuPersonalTypeDTO getMenuTypeName(long id){
        return repositoryMenuPersonalTypeDTO.findMenuTypeName(id);
    }

    public MenuPersonalType getMenuTypeId(long id){
        return repositoryMenuPersonalType.findById(id).get();
    }

}
