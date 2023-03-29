package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: open the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create object of properties from java.util package
		Properties pObj = new Properties();
		
		//Step 3: load the file input stream into properties
		pObj.load(fis);
		
		//Step 4: access the values with Keys.
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("Username");
		
		System.out.println(URL);
		System.out.println(USERNAME);
		
		
	}

}
