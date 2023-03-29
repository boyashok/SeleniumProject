package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelPractice {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Get control of Sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Step 4: Get control of Row
		Row rw = sh.getRow(4);
		
		//Step 5: Get control of Cell
		Cell ce = rw.getCell(2);
		
		//Step 6: read the data inside the cell.
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		
		
	}

}
