package com.example.projectmanagement.util;

import com.example.projectmanagement.entity.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {

    private static final String FILE_PATH = "employees.xlsx";

    public static void writeToExcel(List<Employee> employees) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employees");

        // Header Row
        Row headerRow = sheet.createRow(0);
       
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Task");
        headerRow.createCell(2).setCellValue("Project");

        // Data Rows
        int rowNum = 1;
        for (Employee employee : employees) {
            Row row = sheet.createRow(rowNum++);
            
            row.createCell(0).setCellValue(employee.getName());
            row.createCell(1).setCellValue(employee.getTask());
            row.createCell(2).setCellValue(employee.getProject());
        }

        // Write to File
        try (FileOutputStream fileOut = new FileOutputStream(new File(FILE_PATH))) {
            workbook.write(fileOut);
            System.out.println("Excel file created at: " + FILE_PATH);
        } finally {
            workbook.close();
        }
    }

    public static String getFilePath() {
        return FILE_PATH;
    }
}
