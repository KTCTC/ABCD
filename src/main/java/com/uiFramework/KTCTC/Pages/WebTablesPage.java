package com.uiFramework.KTCTC.Pages;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;
import com.uiFramwork.KTCTC.ObjectPages.WebTableObjectClass;


/**
 * @author 91992
 *
 */
public class WebTablesPage {
	private Logger log = LoggerHelper.getLogger(WebTablesPage.class);
 private WebDriver driver = null;
By webTablesPage = By.xpath("//*[@class='element-group']//*[contains(text(),'Web Tables')]");
By addButtonOnwebTablesPage = By.id("addNewRecordButton");
By searchBoxOnwebTablesPage = By.id("searchBox");
By editButtonOnwebTablesPage = By.xpath("//*[@title='Edit']");
By deleteButtonOnwebTablesPage = By.xpath("//*[@title='Delete']");
By firstRowsOnOnwebTablesPage = By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]");
// Locators for registration form
By firstNameOnRegistrationForm = By.id("firstName");
By lastNameOnRegistrationForm = By.id("lastName");
By emaiIdOnRegistrationForm = By.id("userEmail");
By ageOnRegistrationForm = By.id("age");
By salaryOnRegistrationForm = By.id("salary");
By departmentOnRegistrationForm = By.id("department");
By submitButtonOnRegistrationForm = By.id("submit");
//
By firstNameOnWebTable = By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]/div[1]");

public WebTablesPage(WebDriver driver)
{
	this.driver = driver;
}
/*
 * @FindBy(xpath =
 * "//*[@class='element-group']//*[contains(text(),'Web Tables')]") WebElement
 * webTablePage;
 * 
 * @FindBy(id="addNewRecordButton") WebElement addButton;
 * 
 * 
 * public WebTablesPage(WebDriver driver) { PageFactory.initElements(driver,
 * this); }
 */
 



/**
 * Method navigates to Webtable page
 * @param driver
 */
public void navigateToWebTablePage()
{
	log.info("Navigating to WebTable page...");
	driver.findElement(webTablesPage).click();
	log.info("Navigated to WebTable page");
}

/**
 * Method creates new user on WebTable page with provided data
 * @param driver
 * @param fName
 * @param lName
 * @param emailId
 * @param age
 * @param salary
 * @param department
 */
public void addNewUserOnWebTablePage(WebTableObjectClass newUserData)
{
	log.info("Adding new user with provided details");
	driver.findElement(addButtonOnwebTablesPage).click();
	WaitHelper wt = new WaitHelper(driver);
	wt.waitForElement(driver.findElement(firstNameOnRegistrationForm), 4);
	driver.findElement(firstNameOnRegistrationForm).sendKeys(newUserData.getfName());
	driver.findElement(lastNameOnRegistrationForm).sendKeys(newUserData.getlName());
	driver.findElement(emaiIdOnRegistrationForm).sendKeys(newUserData.getEmailId());
	driver.findElement(ageOnRegistrationForm).sendKeys(newUserData.getAge());
	driver.findElement(salaryOnRegistrationForm).sendKeys(newUserData.getSalary());
	driver.findElement(departmentOnRegistrationForm).sendKeys(newUserData.getDepartment());
	driver.findElement(submitButtonOnRegistrationForm).click();
	log.info("New user is added");	
}

/**
 * Method serchs given string in search box
 * @param driver
 * @param str
 */
public void serchInSerchBoxOfWebTablePage(String str)
{
	log.info("Serching string in serch box");
   driver.findElement(searchBoxOnwebTablesPage).clear();
   driver.findElement(searchBoxOnwebTablesPage).sendKeys(str);

}
/**
 * Method returns true if mentioned record present
 * @param driver
 * @param str
 * @return
 */
public boolean isSerchedUserPresentOnWebTablePage(String str)
{
	serchInSerchBoxOfWebTablePage(str);
	boolean flag=false;
	  // WaitHelper wt = new WaitHelper(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 2);
	  try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstRowsOnOnwebTablesPage).findElement(By.xpath("//div[contains(text(),'"+str+"')]"))));
		flag = true;
		log.info("given  records is present");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("given  records is not present");
	}
	
	 return flag;  
}
 
/**
 * Method returns all details of required user
 * @param driver
 * @param str
 * @return
 */
public HashMap<String,String> getAllDetailsOfRequiredUserOnWebTablePage(String str)
{
	serchInSerchBoxOfWebTablePage(str);
	log.info("Getting all details of required user...");
	HashMap< String, String> data = new HashMap<>();	
	data.put("firstName", driver.findElement(By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]/div[1]")).getText());
	data.put("lastName", driver.findElement(By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]/div[2]")).getText());
	data.put("age", driver.findElement(By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]/div[3]")).getText());
	data.put("emailid", driver.findElement(By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]/div[4]")).getText());
	data.put("salary", driver.findElement(By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]/div[5]")).getText());
	data.put("department", driver.findElement(By.xpath("//*[@class='rt-table']//*[contains(@class,'rt-tr -odd')]/div[6]")).getText());
	log.info("All details of required user are returned ");
	return data;
	 
}
/**
 * Method edits all fields of existing user
 * @param driver
 * @param existingUser
 * @param fName
 * @param lName
 * @param emailId
 * @param age
 * @param salary
 * @param department
 */
public void editDetailsOfExistingUserOnWebTablePage(String existingUser, WebTableObjectClass updated)
{
	serchInSerchBoxOfWebTablePage(existingUser);
	log.info("Editing all fields of existing user...");
	driver.findElement(editButtonOnwebTablesPage).click();
	WaitHelper wt = new WaitHelper(driver);
	wt.waitForElement(driver.findElement(firstNameOnRegistrationForm), 4);
	driver.findElement(firstNameOnRegistrationForm).clear();
	driver.findElement(firstNameOnRegistrationForm).sendKeys(updated.getfName());
	driver.findElement(lastNameOnRegistrationForm).clear();
	driver.findElement(lastNameOnRegistrationForm).sendKeys(updated.getlName());
	driver.findElement(emaiIdOnRegistrationForm).clear();
	driver.findElement(emaiIdOnRegistrationForm).sendKeys(updated.getEmailId());
	driver.findElement(ageOnRegistrationForm).clear();
	driver.findElement(ageOnRegistrationForm).sendKeys(updated.getAge());
	driver.findElement(salaryOnRegistrationForm).clear();
	driver.findElement(salaryOnRegistrationForm).sendKeys(updated.getSalary());
	driver.findElement(departmentOnRegistrationForm).clear();
	driver.findElement(departmentOnRegistrationForm).sendKeys(updated.getDepartment());
	driver.findElement(submitButtonOnRegistrationForm).click();
	log.info("Fields of user edited successfully");
	
}
/**Method deletes existing user
 * @param driver
 * @param existingUser
 */
public void deleteExistingUserFromWebTablePage(String existingUser)
{
	log.info("Deleting existing user...");
	serchInSerchBoxOfWebTablePage(existingUser);
	driver.findElement(deleteButtonOnwebTablesPage).click();
	log.info("Existing user is deleted");
	
	
}
	
}
