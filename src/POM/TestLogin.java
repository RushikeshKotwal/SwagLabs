package POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin 
{
	WebDriver driver;
	LoginPage login;
	Sheet sh;
	
	@BeforeClass
	public void browseropen() throws EncryptedDocumentException, IOException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream file=new FileInputStream("D:\\SwagLabs.xlsx");
		sh=WorkbookFactory.create(file).getSheet("Sheet1");
		
	}
	
	@BeforeMethod
	public void login() throws InterruptedException
	{
		login=new LoginPage(driver);
		login.inpUN(sh.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(2000);
		login.inppwd(sh.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		login.clicklogin();
	}
	
	@Test
	public void test()
	{
		
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		MenuPage menu=new MenuPage(driver);
		Thread.sleep(2000);
		menu.clickMenupage();
		Thread.sleep(2000);
		menu.clickLogout();
	}
	
	@AfterClass
	public void browserclose() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}

}
