package com.IdentifyNewBikes.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtils {

	public void writeData(String price, String name, String lunch, int rows) throws Exception {
		String src = "C:\\Users\\hp\\eclipse-workspace\\IdentifyNewBikes\\Excel_Output\\BikesAndCars.xlsx";
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.createRow(rows);
		for (int i = 0; i <= 2; i++) {
			if (i == 0) {
				row.createCell(i).setCellValue(price);
			} else if (i == 1) {
				row.createCell(i).setCellValue(name);
			} else if (i == 2) {
				row.createCell(i).setCellValue(lunch);
			}
		}
		FileOutputStream fos = new FileOutputStream(src);
		workbook.write(fos);
		workbook.close();
	}
	
	public void writeData1(String[] Cars) throws Exception {
		String src = "C:\\Users\\hp\\eclipse-workspace\\IdentifyNewBikes\\Excel_Output\\BikesAndCars.xlsx";
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		int length=Cars.length;
		for(int i=0;i<length;i++) {
			Row row=sheet.createRow(i+2);
			row.createCell(0).setCellValue(Cars[i]);
		}
		FileOutputStream fos = new FileOutputStream(src);
		workbook.write(fos);
		workbook.close();
	}

}
