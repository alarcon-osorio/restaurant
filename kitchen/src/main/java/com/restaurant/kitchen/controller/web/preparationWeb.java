package com.restaurant.kitchen.controller.web;

import com.restaurant.kitchen.service.ServicePrepared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class preparationWeb {

    @Autowired
    ServicePrepared servicePrepared;

    @RequestMapping(value = "/prepare")
    public String savePrepare(@RequestParam long id){
        servicePrepared.prepareOrder(id);
        return "redirect:/kitchen?table=0";
    }

    @RequestMapping(value = "/prepared")
    public String savePrepared(@RequestParam long id){
        servicePrepared.preparedOrder(id);
        return "redirect:/kitchen?table=0";
    }

}
