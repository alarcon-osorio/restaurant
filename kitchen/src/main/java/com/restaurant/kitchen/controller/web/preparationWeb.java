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

    @RequestMapping(value = "/served")
    public String saveServed(@RequestParam long id){
        servicePrepared.servedOrder(id);
        return "redirect:/kitchen?table=0";
    }

    @RequestMapping(value = "/prepare_table")
    public String savePrepareByTable(@RequestParam long table){
        servicePrepared.prepareOrderByTable(table);
        return "redirect:/kitchen?table=" + table;
    }

    @RequestMapping(value = "/prepared_table")
    public String savePreparedByTable(@RequestParam long table){
        servicePrepared.preparedOrderByTable(table);
        return "redirect:/kitchen?table=" + table;
    }

    @RequestMapping(value = "/served_table")
    public String saveServedByTable(@RequestParam long table){
        servicePrepared.servedOrderByTable(table);
        return "redirect:/kitchen?table=" + table;
    }


}
