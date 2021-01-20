package Acadamy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	 @BeforeTest
	public void initializeDriver() throws IOException 
	{
		driver = initialize();
		//driver.get(prop.getProperty("url"));
	}  
	
	@Test(dataProvider="getData")
	public void baseHomePage(String uname,String password,String text) throws IOException
	{
		
		//driver = initialize();
																																																																	driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		l.signin().click();
		LoginPage li = new LoginPage(driver);
		li.email().sendKeys(uname);
		li.password().sendKeys(password);
		//li.login().click();
		System.out.println(text);
		log.info("Home page Navigatio");
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// row stands for how many different data types tests should run
		// columns stands for how many values for each test
		Object data[][] = new Object[2][3];
		//1 st set 
		data[0][0] = "nonristricted@qk.com";
		data[0][1] = "2345";
		data[0][2] = "Non Ristrickted User";
		//2 nd set
		data[1][0] = "nonrestricted@qk.com";
		data[1][1] = "2345";
		data[1][2] = "Restricted User";
		return data;
		
	}

}
