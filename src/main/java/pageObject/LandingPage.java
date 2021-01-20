package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signin =By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By contact = By.xpath("//a[text()='Contact']");
	


	public WebElement signin()
	{
		return driver.findElement(signin);
	}

	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getContact()
	{
		return driver.findElement(contact);
	}
}
