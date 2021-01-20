package Acadamy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.ExtentReportNG;

public class Listeners extends Base implements ITestListener{
	
	ExtentReports extent =ExtentReportNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest>	extentTest  = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 extentTest.get().log(Status.PASS, "Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		extentTest.get().fail(result.getThrowable());
		// to get failed test method name 
		String testMethodName = result.getMethod().getMethodName();
		try {
			// to acces the actual instance of the failed testcase object(driver) scope
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception  e) {
			// TODO Auto-generated catch block
		
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
			}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
