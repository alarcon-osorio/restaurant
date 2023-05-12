package com.restaurant.admin.controller;

import com.restaurant.admin.entity.Discount;
import com.restaurant.admin.entity.PaymentMethod;
import com.restaurant.admin.service.ServiceDiscount;
import com.restaurant.admin.service.ServicePaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebPaymentDiscount {

    @Autowired
    ServiceDiscount serviceDiscount;

    @Autowired
    ServicePaymentMethod servicePaymentMethod;

    @GetMapping("paymentDiscount")
    public String getPaymentDiscount(Model model){
        List<PaymentMethod> paymentMethodList = servicePaymentMethod.getPaymentMethod();
        List<Discount> discountList = serviceDiscount.getDiscount();
        model.addAttribute("paymentMethodList", paymentMethodList);
        model.addAttribute("discountList", discountList);
        return "pages/tables/payment-discount";
    }


}
