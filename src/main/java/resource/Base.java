package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initialize() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\SWAMI COOL\\eclipse-workspace\\E2EProject\\src\\main\\java\\resource\\Data.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\GeckoDriver\\geckodriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Work\\Selenium\\IEdriverserver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	} 
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}


}
