package com.restaurant.client.controller.rest;

import com.restaurant.client.entity.MenuAccompaniment;
import com.restaurant.client.service.ServiceMenuAccompaniment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin(origins = "*")
public class MenuAccompanimentController {

    @Autowired
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @GetMapping(value = "/menu_accompaniment")
    public List<MenuAccompaniment> getManuAccompaniment(){
        return serviceMenuAccompaniment.getMenuAccompanimentList();
    }

    @GetMapping(value = "/menu_accompaniment/{id}")
    public MenuAccompaniment getMenuAccompanimentId(@PathVariable(name="id") long id){
        return serviceMenuAccompaniment.getMenuAccompanimentId(id);
    }

    @GetMapping(value = "/menu_accompaniment/menu_id/{id}")
    public List<MenuAccompaniment> getMenuAccompanimentMenuId(@PathVariable(name="id") long id){
        return serviceMenuAccompaniment.getMenuAccompanimentMenuId(id);
    }}
