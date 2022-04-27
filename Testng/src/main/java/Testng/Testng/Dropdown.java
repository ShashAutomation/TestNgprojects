package Testng.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdown {
	WebDriver driver;
	@BeforeMethod
	public void chromeLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		
	}
	@Test(priority=1)
	public void dropdown1() throws InterruptedException
	{
		driver.navigate().to("https://account.magento.com/customer/account/create/");
		Select s=new Select(driver.findElement(By.id("company_type")));
		s.selectByValue("selling");
		Select s1=new Select(driver.findElement(By.id("individual_role")));
		s1.selectByVisibleText("Technical/developer");
		Thread.sleep(2000);
        }
	@Test(priority=2)
	public void dropdown2() throws InterruptedException
	{
		driver.navigate().to("https://www.roblox.com/");
		Select s=new Select(driver.findElement(By.id("MonthDropdown")));
		s.selectByValue("Oct");
		Select s1=new Select(driver.findElement(By.id("DayDropdown")));
		s1.selectByVisibleText("15");
		Select s2=new Select(driver.findElement(By.id("YearDropdown")));
		s2.selectByIndex(26);
		Thread.sleep(2000);
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
