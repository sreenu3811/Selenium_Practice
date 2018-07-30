package login_Page;

import org.testng.annotations.Test;

public class TestPage {
	@Test(priority=1,groups="regression")
	public void TestOne()
	{
		System.out.println("testOne");
	}
	@Test(priority=2,groups="smoke")
	public void TestTwo()
	{
		System.out.println("testTwo");
	}
	@Test(priority=3,groups="UI")
	public void TestThree()
	{
		System.out.println("testThree");
	}
	

}
