package POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LoginTest {
	
	@Test
	public void LoginTEST() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		
		FileInputStream file=new FileInputStream("D:\\SwagLabs.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet1");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage login=new LoginPage(driver);
		login.inpUN(sh.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(2000);
		login.inppwd(sh.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		login.clicklogin();
		
		MenuPage menu=new MenuPage(driver);
		Thread.sleep(2000);
		menu.clickMenupage();
		Thread.sleep(2000);
		menu.clickLogout();
		
		Thread.sleep(2000);
		driver.close();
		

	}

}
