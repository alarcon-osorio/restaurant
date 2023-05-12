package com.restaurant.admin.controller;

import com.restaurant.admin.entity.Modules;
import com.restaurant.admin.service.ServiceModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebModules {

    @Autowired
    ServiceModules serviceModules;

    @RequestMapping("/modules")
    public String getModules(Model model){
        List<Modules> modulesList = serviceModules.findModules();
        model.addAttribute("modulesList", modulesList);
        return "viewModules";
    }

}
