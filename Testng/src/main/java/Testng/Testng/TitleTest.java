package Testng.Testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TitleTest{
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
	public void googleTitleTest() throws InterruptedException
	{
	 String title=driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals(title, "Google","title not matched");
	 
	
		
	}
		@Test(priority=2)
		public void facebookTitleTest()
		{
			driver.navigate().to("https://www.facebook.com/");
			 String title=driver.getTitle();
			 System.out.println(title);
			 Assert.assertEquals(title, "Google","Title not matched");
			 
		}
		@AfterMethod
		public void close()
		{
			driver.quit();
		}
	}


