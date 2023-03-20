package com.restaurant.client.controller.rest;

import com.restaurant.client.entity.Menu;
import com.restaurant.client.service.ServiceMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    ServiceMenu serviceMenu;

    @GetMapping(value = "/menu")
    public List<Menu> menu(){
        return serviceMenu.getMenu();
    }

    @GetMapping(value = "/menu/{id}")
    public Menu idMenu(@PathVariable(name="id") long id){
        return serviceMenu.getMenuId(id);
    }

    @PutMapping(value = "/menu/{id}")
    public Menu Ordered(@PathVariable(name="id") long id){
        Menu menu = serviceMenu.getMenuId(id);
        menu.setOrdered(1);
        return serviceMenu.ordered(menu);
    }


}
