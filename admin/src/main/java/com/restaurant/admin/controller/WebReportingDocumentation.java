package com.restaurant.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class WebReportingDocumentation {

    @RequestMapping("/reportings")
    public String getReporting(Model model){
        return "pages/charts/chartjs";
    }

    @RequestMapping("/documentations")
    public String getDocumentation(Model model){
        return "pages/documentation/documentation";
    }

}
