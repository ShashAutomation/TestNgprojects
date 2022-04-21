package Testng.Testng;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class screenshotTest {
	

	WebDriver driver;

	@BeforeMethod
	public void chromeLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}

		@Test
		public void screenshot() throws IOException, InterruptedException
		{
			driver.findElement(By.xpath("//a[contains(@class,'gb_d')]")).click();
			Thread.sleep(2000);
			File scrshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrshot , new File("C:\\Users\\shashidhar\\Documents\\Corel\\screenshot.png"));
		}
		@AfterMethod
		public void close()
		{
			driver.quit();
		}
	}


