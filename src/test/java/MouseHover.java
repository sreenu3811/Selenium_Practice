import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	
	@Test
	public void mouseHover()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.navigate().to("http://www.amazon.com/");

		WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList"));
		
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript,element);
	}

}
