package practice;

import java.io.IOException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("Contacts", 4, 2);
		System.out.println(value);
		
		System.out.println(eUtil.getRowCount("Contacts"));
		
		eUtil.writeDataIntoExcel("Contacts", 4, 6, "Batman");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInFormat());
		System.out.println(jUtil.getRandomNumber());
		
	}

}
