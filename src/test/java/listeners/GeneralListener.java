package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class GeneralListener implements ITestListener {
	
	public void onTestFailure(ITestResult result){
		System.out.println("Listener on test failure");
	}

}
