package com.restaurant.client.controller.web;

import com.restaurant.client.entity.Clients;
import com.restaurant.client.entity.Menu;
import com.restaurant.client.entity.MenuType;
import com.restaurant.client.service.ServiceClients;
import com.restaurant.client.service.ServiceMenu;
import com.restaurant.client.service.ServiceMenuType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class ClientsWeb {

    @Autowired
    ServiceClients serviceClients;

    @Autowired
    ServiceMenu serviceMenu;

    @Autowired
    ServiceMenuType serviceMenuType;

    @RequestMapping(value = "/loginClient")
    public String loginClient(Model model) {
        return "loginClient";
    }

    @PostMapping(value = "/loginClient/ingress")
    public String loginClientIngress(Model model) {
        List<Menu> menu = serviceMenu.getMenu();
        List<MenuType> menuTypeList = serviceMenuType.getMenuType();
        model.addAttribute("menu", menu);
        model.addAttribute("menuTypeList", menuTypeList);
        return "viewMenu";
    }

    @RequestMapping(value = "/register")
    public String createClients(Model model) {
        return "register";
    }

    @PostMapping(value = "/registration")
    public String registration(Clients clients, BindingResult result, Model model){
        Clients existingClient = serviceClients.getClientByEmail(clients.getEmail());

        if(existingClient != null && existingClient.getEmail() != null && !existingClient.getEmail().isEmpty()){
            result.rejectValue("email", null,"El email ya se encuentra registrado");
        }

        if(result.hasErrors()){
            model.addAttribute("clients", clients);
            return "/register";
        }

        serviceClients.saveClients(clients);
        return "redirect:/register?success";
    }

}
