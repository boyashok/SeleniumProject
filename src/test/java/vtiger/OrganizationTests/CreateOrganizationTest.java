package vtiger.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createOrganizationTest() throws EncryptedDocumentException, IOException
	{
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
            
		// Step 4: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLnk();

		// Step 5: Click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();

		// Step 6: Create Organization with mandatory details
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);

		// Step 8: Validate
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));

		
	}
	
	@Test(groups = "RegressionSuite")
	public void demoScript()
	{
		System.out.println("Demo");
		
	}
	
	@Test
	public void regional() {
		System.out.println("regional regression");
	}

}
