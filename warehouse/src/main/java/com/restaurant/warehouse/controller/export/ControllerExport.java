package com.restaurant.warehouse.controller.export;

import com.restaurant.warehouse.entity.Inventory;
import com.restaurant.warehouse.exporter.ExcelExportUnlisted;
import com.restaurant.warehouse.service.ServiceInventory;
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
    ServiceInventory serviceInventory;

    @GetMapping("export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=inventory_qleko" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<Inventory> closeDaysList = serviceInventory.findInventory();
        ExcelExportUnlisted excelExporter = new ExcelExportUnlisted(closeDaysList);
        excelExporter.export(response);

    }
}
