package com.xworkz.excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	private static String filepath="C:\\Users\\hp\\Desktop\\StudentDetails.xlsx";
	
	public static void main(String[] args) {
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(filepath);
			
			XSSFSheet sheet = workbook.getSheet("sheet1");
			
			int rows = sheet.getLastRowNum();
			int coloumn =sheet.getRow(1).getLastCellNum();
			
			for (int i = 0; i <=rows; i++) {
				XSSFRow row = sheet.getRow(i);
				
				 for (int j = 0; j < coloumn; j++) {
					 XSSFCell  cell = row.getCell(j);
					 switch(cell.getCellType()) {
					 case STRING :System.out.println(cell.getStringCellValue());break;
					 case NUMERIC :System.out.println(cell.getNumericCellValue());break;
					 case BOOLEAN  :System.out.println(cell.getBooleanCellValue());break;
					 }
					 System.out.println("\t\t");
					
				}
				 System.out.println("----------------------------------");
				 workbook.close();
				 
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
