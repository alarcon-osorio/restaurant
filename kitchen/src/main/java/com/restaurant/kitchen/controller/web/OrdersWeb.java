package com.restaurant.kitchen.controller.web;

import com.restaurant.kitchen.entity.ServiceOrder;
import com.restaurant.kitchen.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrdersWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @RequestMapping(value = "/kitchen")
    public String getServiceOrderAll(Model model, @RequestParam long table){
        List<String> tableDistinct = serviceOrders.getTableNumberDistinct();
        model.addAttribute("tableDistinct", tableDistinct);
        if (table == 0){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrderList();
            if (serviceOrderList.isEmpty()){
                model.addAttribute("empty", "ok");
                return "viewOrders";
            }
            model.addAttribute("serviceOrderList", serviceOrderList);
            model.addAttribute("allOrders", "ok");
            return "viewOrders";
        }else{
            List<ServiceOrder> serviceOrderByTable = serviceOrders.getByTableNumber(table);
            if (serviceOrderByTable.isEmpty()){
                model.addAttribute("empty", "ok");
                return "viewOrders";
            }
            for (ServiceOrder serviceOrder: serviceOrderByTable){
                if (serviceOrder.getOrdered() == 1 && serviceOrder.getPrepare() == 0 && serviceOrder.getPrepared() == 0){
                    model.addAttribute("ordered", "ok");
                }else if(serviceOrder.getOrdered() == 1 && serviceOrder.getPrepare() == 1 && serviceOrder.getPrepared() == 0 ){
                    model.addAttribute("prepare", "ok");
                }else if(serviceOrder.getOrdered() == 1 && serviceOrder.getPrepare() == 1 && serviceOrder.getPrepared() == 1 ){
                    model.addAttribute("prepared", "ok");
                }
            }
            model.addAttribute("table", table);
            model.addAttribute("serviceOrderByTable", serviceOrderByTable);
            model.addAttribute("ordersByTable", "ok");
            return "viewOrders";
        }
    }

}
