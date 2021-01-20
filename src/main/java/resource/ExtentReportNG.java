package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
	
	// ExtentReports    ExtentSparkReporter
			// -- user.dir = it will get the current project path to create new folder
			// -- reports = package name
			// -- index.html = report
			String path = System.getProperty("user.dir")+ "\\reports\\index.html";
			ExtentSparkReporter reports = new ExtentSparkReporter(path);
			reports.config().setReportName("Web Automation Results");
			reports.config().setDocumentTitle("Test Results");
			
			extent = new ExtentReports();	
			extent.attachReporter(reports);
			extent.setSystemInfo("Test", "Dhoraswami K");
			return extent;

}
}