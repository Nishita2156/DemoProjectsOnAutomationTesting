package com.etsy.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelUtils {
	public static List<String> getProductsFromExcel(String path, String sheetName) {
        List<String> productList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rows = sheet.iterator();
            rows.next(); // Skip header

            while (rows.hasNext()) {
                Row row = rows.next();
                String product = row.getCell(0).getStringCellValue();
                productList.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

}
