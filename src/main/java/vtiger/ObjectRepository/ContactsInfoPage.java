package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	public ContactsInfoPage(WebDriver driver) //test script
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture the text from Org Header and return it to caller
	 * @return
	 */
	public String getContactHeader()
	{
		return ContactHeaderText.getText();
	}

}
