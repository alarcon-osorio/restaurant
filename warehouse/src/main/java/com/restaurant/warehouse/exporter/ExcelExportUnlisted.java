package com.restaurant.warehouse.exporter;

import com.restaurant.warehouse.entity.Inventory;
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
    private List<Inventory> inventories;

    public ExcelExportUnlisted(List<Inventory> inventories) {
        this.inventories = inventories;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Inventory");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "id");
        createCell(row, 1, "Número de Producto");
        createCell(row, 2, "Nombre");
        createCell(row, 3, "Tipo");
        createCell(row, 4, "Estado");
        createCell(row, 5, "Unidad de Medida");
        createCell(row, 6, "Precio Unitario");
        createCell(row, 7, "Precio Venta");
        createCell(row, 8, "Cantidad Disponible");
        createCell(row, 9, "Cantidad Ordenada");
        createCell(row, 10, "Cantidad Minima");
        createCell(row, 11, "Total");
        createCell(row, 12, "Fecha");
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

        for (Inventory data : inventories) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, data.getId());
            createCell(row, columnCount++, data.getNumberProduct());
            createCell(row, columnCount++, data.getName());
            createCell(row, columnCount++, data.getType());
            createCell(row, columnCount++, data.getStatus());
            createCell(row, columnCount++, data.getMeasureUnit());
            createCell(row, columnCount++, data.getPriceUnit());
            createCell(row, columnCount++, data.getSalePrice());
            createCell(row, columnCount++, data.getCantDisp());
            createCell(row, columnCount++, data.getCantOrder());
            createCell(row, columnCount++, data.getCantMinInv());
            createCell(row, columnCount++, data.getTotalInventory());
            createCell(row, columnCount++, data.getDate());
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

