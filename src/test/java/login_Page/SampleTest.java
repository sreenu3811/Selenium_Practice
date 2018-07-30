package login_Page;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {
	@Test(groups= {"smoke"})
	public void test01()
	{
		System.out.println("Test case 01");
	}
	@Test
	public void test02()
	{
		System.out.println("Test case 02");
	}
	@Test
	public void test03()
	{
		System.out.println("Test case 03");
	}


	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before suite");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After suite");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("before test");
	}
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After test");
	}
	@BeforeGroups
	public void beforeGroups()
	{
		System.out.println("Before groups");
	}
	@AfterGroups
	public void afterGroup()
	{
		System.out.println("After groups");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("After class");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	

}
