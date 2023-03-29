package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class AssertionsPractice {
	
	
	public void sample1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false); 
		
		System.out.println("Step3");
		System.out.println("Step4");
	}

	
	public void sample2()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Second test Step1");
		
		Assert.assertTrue(false); // failed
		
		System.out.println("Second Step2");
		sa.assertEquals("A", "A");// failure
		
		System.out.println("Second Step3");
		sa.assertTrue(false);
		 
		
		System.out.println("Second Step4");
		 //log all the assertion failure
	}
}

















