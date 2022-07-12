package com.restaurante.service.controller.rest;

import com.restaurante.service.entity.MenuType;
import com.restaurante.service.service.ServiceMenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin(origins = "*")
public class MenuTypeController {

    @Autowired
    ServiceMenuType serviceMenuType;

    @GetMapping(value = "/menu_type")
    public List<MenuType> menuTypeList(){
        return serviceMenuType.getMenuType();
    }

    @GetMapping(value = "/menu_type/{id}")
    public MenuType idMenuType(@PathVariable(name="id") long id){
        return serviceMenuType.getMenuTypeId(id);
    }

}
