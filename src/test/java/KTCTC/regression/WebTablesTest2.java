package KTCTC.regression;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.WebTablesPage;
import com.uiFramework.KTCTC.Pages.WebTablesPage2;
import com.uiFramework.KTCTC.testbase.TestBase;
import com.uiFramwork.KTCTC.ObjectPages.WebTablesObjectPage;

public class WebTablesTest2 extends TestBase {
	
	WebTablesObjectPage objPage = new WebTablesObjectPage();
	WebTablesObjectPage objPageNew = new WebTablesObjectPage();
	
	WebTablesPage2 webTablesPage ;
	
	
	@Test (priority = 1)
	public void verifyUserCanNavigateToWebTablePage()
	{
		objPage.setfName(cmObj.getcharacterString(5)); 
		objPage.setlName(cmObj.getcharacterString(5));
		objPage.setEmail(cmObj.getcharacterString(4)+"@"+cmObj.getcharacterString(4)+".com");
		objPage.setAge(cmObj.getNumericString(2));
		objPage.setSalary(cmObj.getNumericString(7));
		objPage.setDepartment(cmObj.getcharacterString(10));
		
		objPageNew.setfName(cmObj.getcharacterString(5)); 
		objPageNew.setlName(cmObj.getcharacterString(5));
		objPageNew.setEmail(cmObj.getcharacterString(4)+"@"+cmObj.getcharacterString(4)+".com");
		objPageNew.setAge(cmObj.getNumericString(2));
		objPageNew.setSalary(cmObj.getNumericString(7));
		objPageNew.setDepartment(cmObj.getcharacterString(10));
		
			
		
		webTablesPage = new WebTablesPage2(driver);
		cmObj.navigateToReQuiredPage(driver, "Element");
		webTablesPage.navigateToWebTablePage();
		
	}
	
	@Test (priority = 2)
	public void verifyNewUserCanBeAddedOnWebTablePage()
	{
		
		webTablesPage.addNewUserOnWebTablePage(objPage);		
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(objPage.getEmail());		
		Assert.assertTrue(flag);
	}
	@Test (priority = 3)
	public void verifyAllDetailsOfNewlyAddedUser()
	{
		HashMap<String, String> details = webTablesPage.getAllDetailsOfProvidedUser(objPage.getEmail());		
		Assert.assertEquals(objPage.getfName(), details.get("FirstName"));
		Assert.assertEquals(objPage.getlName(), details.get("LastName"));
		Assert.assertEquals(objPage.getEmail(), details.get("Email"));
		Assert.assertEquals(objPage.getAge(), details.get("Age"));
		Assert.assertEquals(objPage.getSalary(), details.get("Salary"));
		Assert.assertEquals(objPage.getDepartment(), details.get("Department"));
		
	}
	@Test (priority = 4)
	public void verifyExistingUserCanBeEdited()
	{
		webTablesPage.editExistringUserWithProvidedDetails(objPage.getEmail(), objPageNew);
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(objPageNew.getEmail());		
		Assert.assertTrue(flag);
	}
	@Test (priority = 5)
	public void verifyAllDetailsOfEditedUser()
	{
		HashMap<String, String> details = webTablesPage.getAllDetailsOfProvidedUser(objPageNew.getEmail());
		
		Assert.assertEquals(objPageNew.getfName(), details.get("FirstName"));
		Assert.assertEquals(objPageNew.getlName(), details.get("LastName"));
		Assert.assertEquals(objPageNew.getEmail(), details.get("Email"));
		Assert.assertEquals(objPageNew.getAge(), details.get("Age"));
		Assert.assertEquals(objPageNew.getSalary(), details.get("Salary"));
		Assert.assertEquals(objPageNew.getDepartment(), details.get("Department"));
		
	}
	@Test (priority = 6)
	public void verifyExistringUserCanBeDeleted()
	{
		webTablesPage.deleteExistingUserWithProvidedDetails(objPageNew.getEmail());
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(objPageNew.getEmail());
		Assert.assertFalse(flag);
		
	}

}
