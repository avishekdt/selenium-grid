import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	RemoteWebDriver driver;
	DesiredCapabilities dc;
	
	@BeforeTest
	@Parameters("browser")
	void setup(String browser) throws MalformedURLException
	{
		 dc = new DesiredCapabilities();
		
		if(browser.equals("chrome")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		}
		else if(browser.equals("firefox")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX );
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		}
		
		
		URL url = new URL ("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(url,dc);
		driver.get("http://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public void test1() {
		       
		      System.out.println("launching  browser"); 
//		      System.setProperty("webdriver.chrome.driver", gcdriverPath);
//		      driver = new FirefoxDriver();
//		      driver.get(baseUrl);
		      String expectedTitle = "Welcome: Mercury Tours";
		      String actualTitle = driver.getTitle();
		      Assert.assertEquals(actualTitle, expectedTitle);
		      driver.close();
		  }
	


	
	@AfterTest
	void teardown() {
		driver.quit();
		
	}

}
