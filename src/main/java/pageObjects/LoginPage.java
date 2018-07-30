package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import HomePage.TestHomePage;
import helper.WaitHelper;
import resources.DataSource;
import testBase.TestBase;

public class LoginPage{
	private WebDriver driver;
	
	@FindBy(xpath="//input[@name='user_name']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='user_password']")
    WebElement password;
	
	@FindBy(xpath="//input[@id='submitButton']")
	WebElement logIn;
	
	public LoginPage(WebDriver driver)
	{ 
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WaitHelper waithelper=new WaitHelper(driver);
		waithelper.waitForElement(username,DataSource.getExpliciwait() );
	}
	
	public void setUsername(String user)
	{
		username.sendKeys(user);
	}
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void setLogin()
	{
		logIn.click();
	}
	public HomePage getlogin(String u,String p)
	{
		setUsername(u);
		setPassword(p);
		setLogin();
		return new HomePage(driver);
		
	}
	
}
