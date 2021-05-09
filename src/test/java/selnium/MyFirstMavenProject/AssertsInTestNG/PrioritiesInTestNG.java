package selnium.MyFirstMavenProject.AssertsInTestNG;

import org.testng.annotations.Test;

public class PrioritiesInTestNG {
	
	@Test(priority = 0)
	public void D()
	{
		System.out.println("This is method D");
	}
	
	@Test (priority = 1)
	public void B()
	{
		System.out.println("This is method B");
	}
	@Test (priority = 2)
	public void C()
	{
		System.out.println("This is method C");
	}
	@Test(priority = 3)
	public void A()
	{
		System.out.println("This is method A");
	}

}
