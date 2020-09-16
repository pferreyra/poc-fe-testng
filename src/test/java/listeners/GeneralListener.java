package listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import helpers.BaseTest;
import io.qameta.allure.Attachment;

public class GeneralListener implements ITestListener {	

	private WebDriver driver;

	@Attachment(value="filename", type="image/jpg")
	public void onTestFailure(ITestResult result){
        this.driver = ((BaseTest)result.getInstance()).driver;
        String methodIdentifier = result.getInstance().getClass().getSimpleName() + "-" + result.getName();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filename =  new SimpleDateFormat("yyyy-MM-dd_hhmmss'.jpg'").format(new Date());
		String destFile= System.getProperty("java.io.tmpdir") + methodIdentifier + "-" + filename;		
		try {
			Files.copy(
					screenshot.toPath(),
					Paths.get(destFile),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //TODO Poner un método aparte para crear el nombre del screenshot y darle destino

	}

}