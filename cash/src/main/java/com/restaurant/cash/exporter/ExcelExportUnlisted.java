package com.restaurant.cash.exporter;

import com.restaurant.cash.dto.CloseDay;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelExportUnlisted {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<CloseDay> closeDays;

    public ExcelExportUnlisted(List<CloseDay> closeDays) {
        this.closeDays = closeDays;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("DataRegistry");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "id");
        createCell(row, 1, "Fecha de cierre");
        createCell(row, 2, "Nombre");
        createCell(row, 3, "Mesa");
        createCell(row, 4, "Cantidad");
        createCell(row, 5, "Total");
        createCell(row, 6, "Descuento");
        createCell(row, 7, "Metodo de pago");

    }

    private void createCell(Row row, int columnCount, Object value) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else {
            cell.setCellValue((String) value);
        }
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(10);
        style.setFont(font);

        for (CloseDay data : closeDays) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, data.getId());
            createCell(row, columnCount++, data.getTime());
            createCell(row, columnCount++, data.getName());
            createCell(row, columnCount++, data.getTableNumber());
            createCell(row, columnCount++, data.getCant());
            createCell(row, columnCount++, data.getTotalItem());
            createCell(row, columnCount++, data.getDiscount());
            createCell(row, columnCount++, data.getPaymentMethod());
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }


}

