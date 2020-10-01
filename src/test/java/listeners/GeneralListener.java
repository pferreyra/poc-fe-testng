package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import helpers.BaseTest;
import io.qameta.allure.Attachment;

public class GeneralListener implements ITestListener {	

	
	public void onTestFailure(ITestResult result){
		WebDriver driver = ((BaseTest)result.getInstance()).driver;
		takeScreenshot(driver);

	}
	
	/**
	 * Take a screenshot
	 * 
	 * @param driver from the test on execution
	 * @return .png screenshot as Bytes
	 */
	@Attachment(value="Screenshot", type="image/png")
	public byte[] takeScreenshot (WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

}