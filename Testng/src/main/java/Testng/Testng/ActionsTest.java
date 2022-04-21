package Testng.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
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
	@Test(priority=8)
	public  void mouseCursorTest() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//a[@class='gb_d']"));
		
		Actions act1 =new Actions(driver);
		act1.moveToElement(element).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign in")).click();
		
		Thread.sleep(2000);
			
			WebElement element1=driver.findElement(By.xpath("//input[@name='identifier']"));
			Actions act = new Actions(driver);
	    try {
			Action seriesOfActions = act
			         .moveToElement(element1)
			         .click()
			         .sendKeys(element1, "jashashidhar@gmail.com")
			     	 .contextClick()
			         .build();
			seriesOfActions.perform();
			Thread.sleep(5000);
	    }
	    catch(StaleElementReferenceException e)
	    {
	    	element1=driver.findElement(By.xpath("//input[@name='identifier']"));
	    
	    }
		
		
	} 
}
