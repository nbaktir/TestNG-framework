package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriting {

	@Test 
	public void write() throws IOException {
		
		String filePath = System.getProperty("user.dir")+"/src/test/java/practice/Test.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook book = new XSSFWorkbook(fis);
	
		Sheet sheet = book.getSheet("Test");
		sheet.getRow(0).createCell(1).setCellValue("Language");
		sheet.getRow(0).createCell(2).setCellValue("Syntax123");
		
		FileOutputStream fos = new FileOutputStream(filePath);
		book.write(fos);
		fos.close();
		book.close();
		fis.close();
	}
}
