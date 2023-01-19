package com.session.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelHelper {


		XSSFWorkbook wb; // is a class representation of XLSX file.
		XSSFSheet sheetData; // is a class representing a sheet in an XLSX file.
	
		public XSSFCell cell; // is a class representing a cell in a row of XLSX file.
		public XSSFRow row;  // is a class representing a cell in a row of XLS file.

		public ExcelHelper(String excelPath) {

			try {
				FileInputStream inp; // is used to read data from a file
				File src = new File(excelPath);

				inp = new FileInputStream(src);

				wb = new XSSFWorkbook(inp);
				// Specify Sheet Name
				
				


			} catch (Exception e) {
				System.out.println("Excel lib failed due to: " + e.getMessage());
				//e.printStackTrace();
			}

		}

		public String getStringData(String sheetName, int row, int column) throws IOException {

			sheetData = wb.getSheet(sheetName);
			DataFormatter formatter = new DataFormatter();
			String data = formatter.formatCellValue(sheetData.getRow(row).getCell(column));
			//String data = sheetData.getRow(row).getCell(column).getStringCellValue();
			
			return data;
		
		}
		
	


		public int getTotalRows(String sheetName) {
			sheetData = wb.getSheet(sheetName);
			return sheetData.getLastRowNum();
		}
		
		public int getTotalColumns(String sheetName, int rowNumber) {
			sheetData = wb.getSheet(sheetName);
		       row = sheetData.getRow(rowNumber);
		       int colCount = row.getLastCellNum();
		       return colCount;
		}
		
		public void writeData(String sheetName, int row, int column, String data) throws IOException {
			sheetData = wb.getSheet(sheetName);
			sheetData.getRow(row).createCell(column).setCellValue(data);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now(); 
			String append = dtf.format(now);
			//System.out.print(append);
			FileOutputStream fout = new FileOutputStream("D:\\Automation scripts\\data1" + append+ ".xlsx");
			wb.write(fout);
			//wb.close();
			
		}
	}


