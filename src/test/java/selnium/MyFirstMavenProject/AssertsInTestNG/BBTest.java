package selnium.MyFirstMavenProject.AssertsInTestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class BBTest {
	
	String[] expectedList = {"India","is","my","country"};
	
	@Test
	public void verifyUserCanLoginToSystem()
	{
		boolean flag =true;
		assertEquals(flag, true, "test case is failed");
		String pageTile = "Login Page";
		assertEquals(pageTile, "login page", "Page titles is not as expected");
		
	}
	
	@Test
	public void verifyUserCanSendEmail()
	{
		String[] readedList = {"India","is","my","hghgh"};
		assertEquals(readedList, expectedList);
		
	}
	@Test
	public void verifyUserCanSeeEmailInSendBox()
	{
		assertNotEquals(false, true, "This is not equal assert failuer");
	}

}
