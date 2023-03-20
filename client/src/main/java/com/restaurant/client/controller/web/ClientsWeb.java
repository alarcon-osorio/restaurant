package com.restaurant.client.controller.web;

import com.restaurant.client.entity.Clients;
import com.restaurant.client.repository.RepositoryClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ClientsWeb {

    @Autowired
    RepositoryClients repositoryClients;

    @RequestMapping(value = "/register")
    public String createClients(Model model) {
        log.info("Entro aca10");
        return "register";
    }

    @RequestMapping(value = "/registration")
    public String registration(Clients clients, BindingResult result, Model model){

        log.info("Entro aca1");
        Clients existingClient = repositoryClients.findClientsByEmail(clients.getEmail());

        if(existingClient != null && existingClient.getEmail() != null && !existingClient.getEmail().isEmpty()){
            log.info("Entro aca2");
            result.rejectValue("email", null,
                    "El email ya se encuentra registrado");
        }

        if(result.hasErrors()){
            log.info("Entro aca3");
            model.addAttribute("clients", clients);
            return "/register";
        }

        repositoryClients.save(clients);
        return "redirect:/register?success";
    }

}
