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

public class ValidateNavigationBar extends Base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeDriver() throws IOException
	{
		driver = initialize();
		driver.get(prop.getProperty("url"));
	}
	@Test	
	public void navigationBR()
	{
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getContact().isDisplayed());
		log.info(" Navigation Bar");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
