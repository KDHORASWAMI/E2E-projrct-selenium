package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}
	
	By email = By.cssSelector("[id='user_email']");
	By password =By.xpath("//input[@type='password']");
	By login = By.name("commit");
	

	public WebElement email()
	{
		return driver.findElement(email);
		}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement login()
	{
		return driver.findElement(login);
	}

}
