package com.restaurant.client.controller.web;

import com.restaurant.client.security.entity.Clients;
import com.restaurant.client.service.ServiceClients;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ClientsWeb {

    @Autowired
    public ServiceClients serviceClients;

    @Autowired
    public PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/register")
    public String createClients(Model model) {
        return "register";
    }

    @PostMapping(value = "/registration")
    public String registration(@NotNull Clients clients, BindingResult result, Model model){

        Clients existingClient = serviceClients.getClientByEmail(clients.getEmail());

        if(existingClient != null && existingClient.getEmail() != null && !existingClient.getEmail().isEmpty()){
            result.rejectValue("email", null,"El email ya se encuentra registrado");
            return "redirect:/register?emailExist";
        }

        if(result.hasErrors()){
            model.addAttribute("clients", clients);
            return "/register";
        }

        clients.setUsername(clients.getEmail());
        clients.setPassword(passwordEncoder.encode(clients.getPassword()));

        serviceClients.saveClients(clients);
        return "redirect:/register?success";
    }

}
