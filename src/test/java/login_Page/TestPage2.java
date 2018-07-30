package login_Page;

import org.testng.annotations.Test;

public class TestPage2 {
	
	@Test(priority=3,groups="smoke")
	public void TestFour()
	{
		System.out.println("testFour");
	}
	@Test(priority=2,groups="UI")
	public void TestFive()
	{
		System.out.println("testFive");
	}
	@Test(priority=1,groups="smoke")
	public void TestSix()
	{
		System.out.println("testSix");
	}

}
