package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helper.ResourcesHelper;
import pageObjects.LoginPage;
import readDataFromExcel.ReadDataFromExcel;
import resources.DataSource;

public class TestBase extends DataSource{
	
	public WebDriver driver;
	
	public String[][] getDataFromExcel(String excellName,String sheetName) throws IOException
	{
		String excellocation = ResourcesHelper.getResourcePath("\\src\\main\\java\\testData\\")+excellName;
		ReadDataFromExcel readDataFromExcel=new ReadDataFromExcel();
		return readDataFromExcel.getDataFromExcel(excellocation, sheetName);
	}
	public void updateReporting(String excellName,String sheetName,String testcaseName,String status) throws IOException
	{
		String excellocation = ResourcesHelper.getResourcePath("\\src\\main\\java\\testData")+excellName;
		ReadDataFromExcel readDataFromExcel=new ReadDataFromExcel();
		readDataFromExcel.updateReporting(excellocation, sheetName, testcaseName, status);
	}

	
	public void getBrowser(String browser)
	{
		if(System.getProperty("os.name").contains("Windows"))
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}else
			{
				System.setProperty("webdriver.Microsoft.driver", System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver(1).exe");
    			driver = new InternetExplorerDriver();
			}
			
		}

	}
	public String getData(String name)
	{
		return DataSource.property.getProperty(name);
	}
	@BeforeTest
	public void launchBrowser()
	{
		getBrowser(getData("browserType"));
		driver.manage().timeouts().implicitlyWait(getImpliciwait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(getPageLoadTime(), TimeUnit.SECONDS);
	}
	public void getApplicationUrl(String url)
	{
		driver.get(url);
	}
	
	
	
}
