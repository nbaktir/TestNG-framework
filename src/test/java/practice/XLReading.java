package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLReading {

	@Test
	public void read() throws IOException {
		String filePath = "/Users/NY/Desktop/Hello.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		//to read excel, we need to use different classes
		//workbook interface
		//Workbook wbook = new HSSWorkbook(); --> before 2003
		Workbook wbook = new XSSFWorkbook(fis); // 2007 excel file
	
		//get data from xl
		Sheet xlsheet = wbook.getSheet("Sheet1"); 
		Row row = xlsheet.getRow(0); 
		Cell cell=row.getCell(0);  
		
		String value = cell.toString();
		System.out.println(value);
	}
}
