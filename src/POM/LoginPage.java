package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@id='user-name']") private WebElement username;
	@FindBy(xpath = "//input[@id='password']") private WebElement password;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpUN(String UN) 
	{
		username.sendKeys(UN);
		
	}
	
	public void inppwd(String PWD) 
	{
		password.sendKeys(PWD);
	}

	public void clicklogin() 
	{
		loginbtn.click();
	}
}
