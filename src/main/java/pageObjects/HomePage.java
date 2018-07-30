package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.WaitHelper;
import pageObjects.leads.LeadsPage;
import resources.DataSource;
import testBase.TestBase;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//img[@title='vtiger-crm-logo.gif']")
	WebElement logo;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement signOutDrop;
	
	@FindBy(linkText="Sign Out")
	WebElement signOut;
	
	@FindBy(linkText="Leads")
	WebElement leads;
	
	public HomePage(WebDriver driver)
	{
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(logo, DataSource.getExpliciwait());
		
	}
	public LoginPage logOut()
	{
		Actions action=new Actions(driver);
		action.moveToElement(signOutDrop).build().perform();
		signOut.click();
		return new LoginPage(driver);
	}
	
	public LeadsPage navigateToLeads()
	{
		leads.click();
		return new LeadsPage(driver);
				
	}

}
