package com.restaurante.service.controller.web;

import com.restaurante.service.entity.ServiceOrder;
import com.restaurante.service.service.ServiceOrders;
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

    @RequestMapping(value = "/orders")
    public String orders(Model model, long table, boolean add){
        List<ServiceOrder> neatOrderList = serviceOrders.getNeatOrderByTable(table);
        if(!neatOrderList.isEmpty()){
            model.addAttribute("disableButton", "ok");
        }
        List<String> tableNumberList = serviceOrders.getTableNumber();
        model.addAttribute("tableNumberList", tableNumberList);

        if (table == 0){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrder();
            model.addAttribute("serviceOrderList", serviceOrderList);
            model.addAttribute("table", table);
            return "viewOrders";
        }

        try{
            List<ServiceOrder> serviceOrdersByTableNumber = serviceOrders.getByTableNumber(table);
            if (serviceOrdersByTableNumber.isEmpty()){
                model.addAttribute("table", table);
                model.addAttribute("empty", "empty");
                return "viewOrders";
            }
            model.addAttribute("tableNumber", serviceOrdersByTableNumber);
            model.addAttribute("table", table);
            if(add){
                model.addAttribute("success", "ok");
            }
            return "viewOrders";
        }catch (NullPointerException ex){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrder();
            model.addAttribute("serviceOrderList", serviceOrderList);
        }
        return "viewOrders";
    }

    @RequestMapping(value = "/confirm_order")
    public String confirmOrder(Model model, @RequestParam long table){
        serviceOrders.saveOrderTable(table);
        return "redirect:/orders?table=" + table + "&add=true";
    }

}
