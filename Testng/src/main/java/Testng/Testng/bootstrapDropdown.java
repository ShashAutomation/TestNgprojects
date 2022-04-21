package Testng.Testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class bootstrapDropdown {
	WebDriver driver;
	@BeforeMethod
	public void chromeStart()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\selenium projects\\seleniumtestngprojects\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Dimension size=driver.manage().window().getSize();
		System.out.println(size);
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=11)
	public void dropdrowntest() throws InterruptedException
	{
		driver.navigate().to("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
	System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			
			if(list.get(i).getText().equals("JavaScript"))
			{
				list.get(i).click();
			break;
			}
		
		}
		
		
	}
	@AfterMethod
	public void close()
	{
	driver.quit();	
	}
}
