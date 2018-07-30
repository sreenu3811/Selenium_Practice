import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Download {

	  public static void main(String[] args) throws InterruptedException {
	        
	        System.setProperty("webdriver.gecko.driver","D:\\Selenium_Commands\\Selenium_Practice\\drivers\\geckodriver.exe");
	                String baseUrl = "https://eternallybored.org/misc/wget/";
	        WebDriver driver = new FirefoxDriver();

	        driver.get(baseUrl);
	        WebElement downloadButton = driver.findElement(By.linkText("wget-1.19.4-win32.zip"));
	        String sourceLocation = downloadButton.getAttribute("href");
	        System.out.println(sourceLocation);
	        String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

	        try {
	        Process exec = Runtime.getRuntime().exec(wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        } catch (IOException ex) {
	        System.out.println(ex.toString());
	        }
	        driver.close();
	        }
	        
}
