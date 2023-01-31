package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage
{
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement menu;
	@FindBy(xpath="//a[text()='Logout']") private WebElement logout;
	
	public MenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickMenupage()
	{
		menu.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	

}
