package vtiger.ContactsTests;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {

		/* Read data from excel sheet - Test data */
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);

		// Step 4: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLnk();
		Reporter.log("Click on Organizations link successful", true);

		// Step 5: Click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Click on Create Organization look up image successfull");

		// Step 6: Create Organization with mandatory details
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		Reporter.log("create organization successful");

		// Step 8: Validate for Organization
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader + " --- Organization created");

		// Step 9: Navigate to contacts Link
		hp.clickOnContactsLnk();
		Reporter.log("Navigate to contacts Link successful");

		// Step 10:Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Click on create contact look up image successful");

		// Step 11: Create contact with mandatory fields and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		Reporter.log(" create contact successful");

		// Step 16: Validate for Contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader + " --- Contact created ");

	}

}
