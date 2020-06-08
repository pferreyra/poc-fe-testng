package helpers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
	}

	@BeforeClass
	@Parameters("browser")
	public WebDriver setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "chromedriver");
			 driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			 System.setProperty("webdriver.safari.driver", "safaridriver");
             driver = new SafariDriver();
		} else {            
			throw new Exception("Browser is not supported or correct");
		}
    return driver;
}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
