package Acadamy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resource.Base;

public class ValidateTitle  extends Base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeDriver() throws IOException 
	{
		
		driver = initialize();
		log.info("Driver initialied");
		driver.get(prop.getProperty("url"));
		log.info(" Navigated to home page");
	}
	@Test	
	public void validteTitle()
	{
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		Assert.assertEquals(l.getContact().getText(), "COnTACT");
		log.info(" Successfully validaed message ");
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
