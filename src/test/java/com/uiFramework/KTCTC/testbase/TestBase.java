package com.uiFramework.KTCTC.testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.KTCTC.helper.getScreenShot.CaptureScreen;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.property.PropertyFileHelper;
import com.uiFramework.KTCTC.helper.resource.ResourceHelper;
import com.uiFramework.KTCTC.utils.ExtentManager;

public class TestBase {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public CommonMethods cmObj = new CommonMethods();
	CaptureScreen screenObj = new CaptureScreen();
	PropertyFileHelper proObj = new PropertyFileHelper("env.properties");
	@BeforeSuite
	public void beforeSuite() throws Exception{
		extent = ExtentManager.getInstance();
	}
	
	@BeforeClass
	public void beforeClassOfA() {
		driver = ChromeBrowser.getBrowserInstance();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		test = extent.createTest(getClass().getSimpleName());
		driver.get(proObj.getPropertyValueFromFile("baseURL"));
		cmObj.loginToApplication();
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method method){
		test.log(Status.INFO, method.getName()+"**************test started***************");
		log.info("**************"+method.getName()+"Started***************");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = screenObj.getScreenShot(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath);
			log.info(result.getName()+" is Fail");
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, result.getName()+" is pass");
			log.info(result.getName()+" is pass");
			
			
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, result.getName()+" is skipped");
			log.info(result.getName()+" is Skipped");
		}
		test.log(Status.INFO,result.getName()+"**************test Finished***************");
		log.info("**************"+result.getName()+"Finished***************");
		
	}
	
	@AfterClass
	public void afterClass(){
		
			driver.quit();
		
	}
	@AfterSuite
	public void afterSuiteMethod()
	{
		extent.flush();
	}
	

}
