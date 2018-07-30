import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Upload {

	
		 public static void main(String[] args) {
		        System.setProperty("webdriver.gecko.driver","D:\\Selenium_Commands\\Selenium_Practice\\drivers\\geckodriver.exe");
		        String baseUrl = "http://demo.guru99.com/test/upload/";
		        WebDriver driver = new FirefoxDriver();

		        driver.get(baseUrl);
		        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

		        // enter the file path onto the file-selection input field
		        uploadElement.sendKeys("‪‪D:\\my.html");

		        // check the "I accept the terms of service" check box
		        driver.findElement(By.id("terms")).click();

		        // click the "UploadFile" button
		        driver.findElement(By.name("send")).click();
		        }

	}


