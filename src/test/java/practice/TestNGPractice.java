package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(enabled = false)
	public void createUser()
	{
		System.out.println("create");// Java
		Assert.fail();
		
	}
	
	@Test
	public void updateUser()
	{
		System.out.println("update");
	}
	
	@Test
	public void deleteUser()
	{
		System.out.println("delete");
	}

}
