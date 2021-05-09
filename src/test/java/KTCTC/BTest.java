package KTCTC;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.KTCTC.testbase.TestBase;

public class BTest extends TestBase{
	@BeforeClass
	public void beforeClassOfA()
	{
		driver = ChromeBrowser.getBrowserInstance();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test = extent.createTest(getClass().getSimpleName());
		driver.get("https://www.javatpoint.com/");
	}
	@Test
	public void simpleFromB()
	{
		assertTrue(false);
	}
	@Test
	public void simpleFromBB()
	{
		assertTrue(true);
	}

}
