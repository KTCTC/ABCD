package selnium.MyFirstMavenProject.AssertsInTestNG;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class AATest {
	
	@Test
	public void verifyUserCanLoginToSystem()
	{
		System.out.println("Hi");
		assertTrue(true, "Required element is not displayed");
		System.out.println("Hello");
		assertTrue(false, "User name is not displayed on UI");
	}
	
	@Test
	public void verifyUserCanSendEmail()
	{
		System.out.println("verifyUserCanSendEmail1");
		assertTrue(true);
		System.out.println("verifyUserCanSendEmail2");
		assertTrue(false);
		
	}
	@Test
	public void verifyUserCanSeeEmailInSendBox()
	{
		assertFalse(false);
		System.out.println("false assertion 1");
		assertFalse(true, "False asserion is failed so test case is also failed");
		
	}

}
