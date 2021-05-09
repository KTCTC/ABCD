package KTCTC.regression;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.uiFramework.KTCTC.Pages.WebTablesPage;
import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.KTCTC.helper.property.PropertyFileHelper;
import com.uiFramework.KTCTC.testbase.TestBase;
import com.uiFramwork.KTCTC.ObjectPages.WebTableObjectClass;

public class WebTablesTest extends TestBase {
	
	CommonMethods commonMethods = new CommonMethods();
	WebTablesPage webTablesPage = null;
	WebTableObjectClass newUserData = new WebTableObjectClass();
	WebTableObjectClass updatedUserData = new WebTableObjectClass();
	

	
		
		
	
@Test (priority = 0)
public void verfiyNavigationToWebTablePageAndInitialiseData()
{
	webTablesPage = new WebTablesPage(driver);
	commonMethods.navigateToReQuiredPage(driver, "Elements");
	newUserData.setfName(commonMethods.getcharacterString(7));
	newUserData.setlName(commonMethods.getcharacterString(7));
	newUserData.setEmailId(commonMethods.getcharacterString(4) + "@" + commonMethods.getcharacterString(4) + ".com");
	newUserData.setAge(commonMethods.getNumericString(2));
	newUserData.setSalary(commonMethods.getNumericString(4));
	newUserData.setDepartment(commonMethods.getcharacterString(7));	
	updatedUserData.setfName(commonMethods.getcharacterString(7));
	updatedUserData.setlName(commonMethods.getcharacterString(7));
	updatedUserData.setEmailId(commonMethods.getcharacterString(4) + "@" + commonMethods.getcharacterString(4) + ".com");
	updatedUserData.setAge(commonMethods.getNumericString(2));
	updatedUserData.setSalary(commonMethods.getNumericString(4));
	updatedUserData.setDepartment(commonMethods.getcharacterString(7));	
	webTablesPage.navigateToWebTablePage();
	assertTrue(driver.getCurrentUrl().contains("webtables"));	
	
	}
	@Test (priority = 1)
	public void verifyNewUserCanBeAddedOnWebTablePage() {
		webTablesPage.addNewUserOnWebTablePage(newUserData);
		assertTrue(webTablesPage.isSerchedUserPresentOnWebTablePage(newUserData.getEmailId()));

	}

	@Test(priority = 2)
	public void verifyAllDetailsOfAddedUser() {
		HashMap<String, String> data = webTablesPage.getAllDetailsOfRequiredUserOnWebTablePage(newUserData.getEmailId());
		if (data.get("firstName").contains(newUserData.getfName()) && data.get("lastName").contains(newUserData.getlName())
				&& data.get("emailid").contains(newUserData.getEmailId()) && data.get("age").contains(newUserData.getAge())
				&& data.get("salary").contains(newUserData.getSalary()) && data.get("department").contains(newUserData.getDepartment())) {
			assertTrue(true);

		} else {
			assertTrue(false);
		}

	}

	@Test (priority = 3)
	public void verifyExistingUserDetailsCanBeEditedOnWebTablePage() {
		webTablesPage.editDetailsOfExistingUserOnWebTablePage( newUserData.getEmailId(),updatedUserData);
		assertTrue(webTablesPage.isSerchedUserPresentOnWebTablePage(updatedUserData.getEmailId()));
	}

	@Test (priority = 4)
	public void verifyAllDetailsOfEditedUser() {
		HashMap<String, String> data = webTablesPage.getAllDetailsOfRequiredUserOnWebTablePage(updatedUserData.getEmailId());
		if (data.get("firstName").contains(updatedUserData.getfName()) && data.get("lastName").contains(updatedUserData.getlName())
				&& data.get("emailid").contains(updatedUserData.getEmailId()) && data.get("age").contains(updatedUserData.getAge())
				&& data.get("salary").contains(updatedUserData.getSalary()) && data.get("department").contains(updatedUserData.getDepartment())) {
			assertTrue(true);

		} else {
			assertTrue(false);
		}
	}

	@Test (priority = 5)
	public void verifyExistingUserCanBeDeletedOnWebTablePage() {
		webTablesPage.deleteExistingUserFromWebTablePage(updatedUserData.getEmailId());
		assertFalse(webTablesPage.isSerchedUserPresentOnWebTablePage(updatedUserData.getEmailId()));
	}

}
