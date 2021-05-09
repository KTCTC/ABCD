package selnium.MyFirstMavenProject.AssertsInTestNG;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CCTest {
	File f = new File("C:\\Users\\91992\\eclipse-workspace\\MyFirstMavenProject\\testng.xml");
	String str = null;
	WebDriver driver = null;
	
	@Test
	public void sampleMethod()
	{
		assertNull(str);
	}
	@Test
	public void sampleMethod2()
	{
		assertNotNull(f);
	}

}
