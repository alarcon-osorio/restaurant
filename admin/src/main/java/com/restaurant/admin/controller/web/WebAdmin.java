package com.restaurant.admin.controller.web;

import com.restaurant.admin.entity.Menu;
import com.restaurant.admin.entity.ServiceOrder;
import com.restaurant.admin.service.ServiceMenu;
import com.restaurant.admin.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebAdmin {

    @Autowired
    ServiceOrders serviceOrders;

    @RequestMapping("/dashboard")
    public String viewAdmin(Model model){
        List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrders();
        String totalOrders = serviceOrders.getTotalOrders();
        String totalAttend = serviceOrders.getTotalAttend();
        String pendingAttend = serviceOrders.getPendingAttend();
        String cancelled = serviceOrders.getcancelled();
        model.addAttribute("cancelled", cancelled);
        model.addAttribute("pendingAttend", pendingAttend);
        model.addAttribute("totalAttend", totalAttend);
        model.addAttribute("serviceOrderList", serviceOrderList);
        model.addAttribute("totalOrders", totalOrders);
        return "viewAdmin";
    }

}
