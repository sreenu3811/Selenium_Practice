package login_Page;


import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNGException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.DataSource;
import testBase.TestBase;

public class TestLoginPage extends TestBase {
	LoginPage login;
	HomePage home;
	
	@DataProvider(name="testData")
	public Object[][] testData() throws IOException
	{
		String[][] data = getDataFromExcel("Emails.xlsx", "login");
		return data;
	}
	

	@Test(dataProvider="testData")
	public void test_LoginPage(String username,String password,String runmode) throws InterruptedException
	{
		//driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		if(runmode.contains("N"))
		{
			throw new TestNGException("run mode this set of data is N");
		}
		
		HomePage home=login.getlogin(username, password);
	    home.logOut();
	   
	}
	@BeforeClass
	public void beforeClassName()
	{
		getApplicationUrl(DataSource.property.getProperty("url"));
		login=new LoginPage(driver);
	}
	


}
