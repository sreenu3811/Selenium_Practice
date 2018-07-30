package leads_Page;

import java.io.IOException;

import org.testng.TestNGException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.leads.LeadsPage;
import resources.DataSource;
import testBase.TestBase;

public class TestLeadsPage extends TestBase {
	
	LoginPage login;
	HomePage home;
	
	
	@DataProvider(name="testData")
	public Object[][] testData() throws IOException
	{
		String[][] data = getDataFromExcel("Emails.xlsx", "Leads");
		return data;
	}
	@Test(dataProvider="testData")
	public void test_LeadsPage(String userName,String password,String fName,String lName,String cName,String designation,String annualrevenue,String noofemployees,String secondaryemail,String street,String postalCode,String country,
			String description,String phone,String mobile,String fax,String email,String runmode)
	{
		
		if(runmode.contains("N"))
		{
			throw new TestNGException("run mode this set of data is N");
		}
		home=login.getlogin(userName, password);
		LeadsPage lead=home.navigateToLeads();
		lead.getLeadData(fName, lName, cName, designation, annualrevenue, noofemployees, secondaryemail, street, postalCode, country, description, phone, mobile, fax, email, runmode);
		home.logOut();
	}
	@BeforeClass
	public void beforeClassName()
	{
		getApplicationUrl(DataSource.property.getProperty("url"));
		login=new LoginPage(driver);
	}

}
