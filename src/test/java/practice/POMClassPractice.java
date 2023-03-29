package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMClassPractice {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("manager");
//		lp.getSubmitBtn().click();
		
		lp.loginToApp("admin", "manager");
		
		
		
		
	}

}
