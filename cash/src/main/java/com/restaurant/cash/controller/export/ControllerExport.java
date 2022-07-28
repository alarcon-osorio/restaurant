package com.restaurant.cash.controller.export;

import com.restaurant.cash.dto.CloseDay;
import com.restaurant.cash.exporter.ExcelExportUnlisted;
import com.restaurant.cash.service.ServiceCloseDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerExport {

    @Autowired
    ServiceCloseDay serviceCloseDay;

    @GetMapping("export/excel")
    public void exportToExcel(HttpServletResponse response, String date) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=cierre_qleko" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        if(!date.isEmpty()){
            List<CloseDay> closeDaysByDate = serviceCloseDay.getCloseDayByDate(date);
            ExcelExportUnlisted excelExporter = new ExcelExportUnlisted(closeDaysByDate);
            excelExporter.export(response);
        }else{
            List<CloseDay> closeDaysList = serviceCloseDay.getCloseDay();
            ExcelExportUnlisted excelExporter = new ExcelExportUnlisted(closeDaysList);
            excelExporter.export(response);
        }
    }
}
