package com.restaurant.cash.controller.web;

import com.restaurant.cash.dto.CloseDay;
import com.restaurant.cash.entity.Discount;
import com.restaurant.cash.entity.PaymentMethod;
import com.restaurant.cash.entity.ServiceOrder;
import com.restaurant.cash.service.ServiceCloseDay;
import com.restaurant.cash.service.ServiceDiscount;
import com.restaurant.cash.service.ServiceOrders;
import com.restaurant.cash.service.ServicePaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.List;

@Controller
public class CashWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @Autowired
    ServicePaymentMethod servicePaymentMethod;

    @Autowired
    ServiceCloseDay serviceCloseDay;

    @Autowired
    ServiceDiscount serviceDiscount;

    @RequestMapping(value = "/cash_register")
    public String getServiceOrders(Model model, long table){
        List<String> tableDistinct = serviceOrders.getTableNumberDistinct();
        List<ServiceOrder> serviceOrdersByTable = serviceOrders.getServiceOrdersByTable(table);
        if (serviceOrdersByTable.isEmpty()){
            model.addAttribute("nonCash", "ok");
        }
        String totalOrder = serviceOrders.getTotalOrder(table);
        List<PaymentMethod> paymentMethods = servicePaymentMethod.getPaymentMethod();
        List<Discount> discounts = serviceDiscount.getDiscount();
        model.addAttribute("totalOrder", totalOrder);
        model.addAttribute("paymentMethods", paymentMethods);
        model.addAttribute("discounts", discounts);
        model.addAttribute("tableDistinct", tableDistinct);
        model.addAttribute("serviceOrdersByTable", serviceOrdersByTable);
        model.addAttribute("table", table);
        return "viewCash";
    }

    @RequestMapping(value = "/close_cash")
    public String closeCash(Model model, String method, long discount, long table){
        servicePaymentMethod.savePaymentMethod(method, discount, table);
        return "redirect:/cash_register?table=0";
    }

    @RequestMapping(value = "/close_day")
    public String closeDay(Model model, String date){
        if (date !=  null){
            List<CloseDay> closeDayList = serviceCloseDay.getCloseDayByDate(date);
            String totalOrder = serviceCloseDay.getTotalOrderByDate(date);
            if (closeDayList.isEmpty()){
                model.addAttribute("empty", "ok");
            }
            model.addAttribute("date", date);
            model.addAttribute("closeDayList", closeDayList);
            model.addAttribute("totalOrder", totalOrder);
            return "viewCloseDay";
        }

        List<CloseDay> closeDayList = serviceCloseDay.getCloseDay();
        String totalOrder = serviceCloseDay.getTotalOrder();
        model.addAttribute("closeDayList", closeDayList);
        model.addAttribute("totalOrder", totalOrder);

        return "viewCloseDay";
    }

}
