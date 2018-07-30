package pageObjects.leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helper.WaitHelper;
import pageObjects.HomePage;
import resources.DataSource;

public class LeadsPage {
	
	private WebDriver driver;
	
	
	@FindBy(linkText="Leads")
	WebElement leads;
	@FindBy(xpath="//img[@title='Create Lead...']")
	WebElement leadsCreation;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	WebElement firstNameType;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement companyName;
	
	@FindBy(xpath="//input[@name='designation']")
	WebElement designation;
	
	@FindBy(xpath="//select[@name='leadsource']")
	WebElement leadsource;
	
	@FindBy(xpath="//select[@name='industry']")
	WebElement industry;
	
	@FindBy(xpath="//input[@name='annualrevenue']")
	WebElement annualrevenue;
	
	@FindBy(xpath="//input[@name='noofemployees']")
	WebElement noofemployees;
	
	@FindBy(xpath="//input[@id='secondaryemail']")
	WebElement secondaryemail;
	
	@FindBy(xpath="//textarea[@name='lane']")
	WebElement street;
	
	@FindBy(xpath="//input[@id='code']")
	WebElement postalCode;
	
	@FindBy(xpath="//input[@name='country']")
	WebElement country;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement description;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@name='fax']")
	WebElement fax;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//select[@name='leadstatus']")
	WebElement leadstatus;
	
	@FindBy(xpath="//select[@name='rating']")
	WebElement rating;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	WebElement assigntype;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement Save;
	
	Select select;
	
	public LeadsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WaitHelper waithelper=new WaitHelper(driver);
		waithelper.waitForElement(leads, DataSource.getExpliciwait());
		
	}
	
	
	public void clickCreationLeads()
	{
		leadsCreation.click();
	}
	
	public void selectFirstNameType()
	{
		select=new Select(firstNameType);
		select.selectByIndex(1);
	}
	public void enterFirstName(String firstName)
	{
		this.firstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		this.lastName.sendKeys(lastName);
	}
	public void enterCompanyName(String companyName)
	{
		this.companyName.sendKeys(companyName);
	}
	public void enterDesignation(String designation)
	{
		this.designation.sendKeys(designation);
	}
	public void selectLeadsource()
	{
		select=new Select(leadsource);
		select.selectByValue("Self Generated");
	}
	public void selectIndustry()
	{
		select=new Select(industry);
		select.selectByVisibleText("Electronics");
	}
	public void enterAnnualrevenue(String annualrevenue)
	{
		this.annualrevenue.sendKeys(annualrevenue);
	}
	public void enterNoofemployees(String noofemployees)
	{
		this.noofemployees.sendKeys(noofemployees);
	}
	public void enterSecondaryemail(String secondaryemail)
	{
		this.secondaryemail.sendKeys(secondaryemail);
	}
	public void enterStreet(String street)
	{
		this.street.sendKeys(street);
	}
	public void enterPostalCode(String postalCode)
	{
		this.postalCode.sendKeys(postalCode);
	}
	public void enterCountry(String country)
	{
		this.country.sendKeys(country);
	}
	public void enterDescription(String description)
	{
		this.description.sendKeys(description);
	}
	public void enterPhone(String phone)
	{
		this.phone.sendKeys(phone);
	}
	public void enterMobile(String mobile)
	{
		this.mobile.sendKeys(mobile);
	}
	public void enterFax(String fax)
	{
		this.fax.sendKeys(fax);
	}
	public void enterEmail(String email)
	{
		this.email.sendKeys(email);
	}
	public void selectLeadstatus()
	{
		select=new Select(leadstatus);
		select.selectByVisibleText("Hot");
	}
	public void selectRating()
	{
		select=new Select(rating);
		select.selectByVisibleText("Active");
	}
	public void clickAssigntype()
	{
		assigntype.click();
	}
	public void clickSave()
	{
		Save.click();
	}
	public void getLeadData(String fName,String lName,String cName,String designation,String annualrevenue,String noofemployees,String secondaryemail,String street,String postalCode,String country,
			String description,String phone,String mobile,String fax,String email,String runmode)
	{
		
		clickCreationLeads();
		selectFirstNameType();
		enterFirstName(fName);
		enterLastName(lName);
		enterCompanyName(cName);
		enterDesignation(designation);
		selectLeadsource();
		selectIndustry();
		enterAnnualrevenue(annualrevenue);
		enterNoofemployees(noofemployees);
		enterSecondaryemail(secondaryemail);
		enterStreet(street);
		enterPostalCode(postalCode);
		enterCountry(country);
		enterDescription(description);
		enterPhone(phone);
		enterMobile(mobile);
		enterFax(fax);
		enterEmail(email);
		selectLeadstatus();
		selectRating();
		clickAssigntype();
		clickSave();
		
		
	}
	
	
	
	

}
