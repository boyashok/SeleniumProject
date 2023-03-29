package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class DemoTestScriptWithDDTAndGU {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Create Object for all utilities
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		// Step 2: Read all the necessary Data
		/* Read data from property File - Common Data */
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		/* Read data from excel sheet - Test data */
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
               
		WebDriver driver = null;

		// Step 2: Launch the browser - runtime polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser name");
		}

		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);

		// Step 3:Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 4: Click on Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 5: Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 6: Create Organization with mandatory details
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 8: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader + " PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 9: Logout of App
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
