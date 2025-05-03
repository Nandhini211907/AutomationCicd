package Nandhini.TestComponents;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Nandhini.resources.ExtentReporterNg;

public class Listeners extends BaseTest implements ITestListener{
     ExtentReports extent =	ExtentReporterNg.getReportObject();
     ExtentTest test;
     ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	 @Override
	    public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	      
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.log(Status.PASS, "Test is passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	extentTest.get().fail(result.getThrowable());
	    	
	    	try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	     
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	
	    
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Called when a test method fails but is within the defined success percentage
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Called before the start of any test execution
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Called after all tests have been executed
	             extent.flush();
	

}

}