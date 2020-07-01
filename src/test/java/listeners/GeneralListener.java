package listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import helpers.BaseTest;

public class GeneralListener implements ITestListener {	

	private WebDriver driver;

	public void onTestFailure(ITestResult result){
        this.driver = ((BaseTest)result.getInstance()).driver;
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFile= "//Users//paulaferreyra//Documents//Automation//screenshot.jpg";		
		try {
			Files.copy(
					screenshot.toPath(),
					Paths.get(destFile),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
