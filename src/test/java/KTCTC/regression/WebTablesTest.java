package KTCTC.regression;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.WebTablesPage;
import com.uiFramework.KTCTC.testbase.TestBase;

public class WebTablesTest extends TestBase {
	WebTablesPage webTablesPage ;
	String fname = cmObj.getcharacterString(5);
	String lname = cmObj.getcharacterString(5);
	String email = cmObj.getcharacterString(4)+"@"+cmObj.getcharacterString(4)+".com";
	String age = cmObj.getNumericString(2);
	String salary = cmObj.getNumericString(7);
	String department = cmObj.getcharacterString(10);
	String newfname = cmObj.getcharacterString(5);
	String newlname = cmObj.getcharacterString(5);
	String newemail = cmObj.getcharacterString(4)+"@"+cmObj.getcharacterString(4)+".com";
	String newage = cmObj.getNumericString(2);
	String newsalary = cmObj.getNumericString(7);
	String newdepartment = cmObj.getcharacterString(10);
	
	@Test (priority = 1)
	public void verifyUserCanNavigateToWebTablePage()
	{
		webTablesPage = new WebTablesPage(driver);
		cmObj.navigateToReQuiredPage(driver, "Element");
		webTablesPage.navigateToWebTablePage();
		
	}
	
	@Test (priority = 2)
	public void verifyNewUserCanBeAddedOnWebTablePage()
	{
		
		webTablesPage.addNewUserOnWebTablePage(fname, lname, email, age, salary, department);		
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(email);		
		Assert.assertTrue(flag);
	}
	@Test (priority = 3)
	public void verifyAllDetailsOfNewlyAddedUser()
	{
		HashMap<String, String> details = webTablesPage.getAllDetailsOfProvidedUser(email);		
		Assert.assertEquals(fname, details.get("FirstName"));
		Assert.assertEquals(lname, details.get("LastName"));
		Assert.assertEquals(email, details.get("Email"));
		Assert.assertEquals(age, details.get("Age"));
		Assert.assertEquals(salary, details.get("Salary"));
		Assert.assertEquals(department, details.get("Department"));
		
	}
	@Test (priority = 4)
	public void verifyExistingUserCanBeEdited()
	{
		webTablesPage.editExistringUserWithProvidedDetails(email, newfname, newlname, newemail, newage, newsalary, newdepartment);
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(newemail);		
		Assert.assertTrue(flag);
	}
	@Test (priority = 5)
	public void verifyAllDetailsOfEditedUser()
	{
		HashMap<String, String> details = webTablesPage.getAllDetailsOfProvidedUser(newemail);
		
		Assert.assertEquals(newfname, details.get("FirstName"));
		Assert.assertEquals(newlname, details.get("LastName"));
		Assert.assertEquals(newemail, details.get("Email"));
		Assert.assertEquals(newage, details.get("Age"));
		Assert.assertEquals(newsalary, details.get("Salary"));
		Assert.assertEquals(newdepartment, details.get("Department"));
		
	}
	@Test (priority = 6)
	public void verifyExistringUserCanBeDeleted()
	{
		webTablesPage.deleteExistingUserWithProvidedDetails(newemail);
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(newemail);
		Assert.assertFalse(flag);
		
	}

}
