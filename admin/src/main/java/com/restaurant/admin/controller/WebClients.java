package com.restaurant.admin.controller;

import com.restaurant.admin.entity.Clients;
import com.restaurant.admin.service.ServiceClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebClients {

    @Autowired
    ServiceClients serviceClients;

    @RequestMapping("/clients")
    public String getClients(Model model){
        List<Clients> clientsList = serviceClients.findClients();
        model.addAttribute("clientsList", clientsList);
        return "pages/tables/clients";
    }
}
