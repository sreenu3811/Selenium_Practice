package HomePage;


import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;

public class TestHomePage extends TestBase{
	
	HomePage homePage;
	@Test
	public void  testSinOut()
	{
		homePage=new HomePage(driver);
		homePage.logOut();
	}
	

}
