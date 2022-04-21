package Testng.Testng;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksOfPage {
	WebDriver driver;
	@BeforeMethod
	public void chromeLaunch()
	{
	
			System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.google.com/");
            driver.navigate().to("https://www.adobe.com/in/");
	}
	@Test
	public void list() throws MalformedURLException, IOException
	{
		
			List<WebElement>linklist =driver.findElements(By.tagName("a"));
			linklist.addAll(driver.findElements(By.tagName("img")));
			System.out.println(linklist.size());
			List<WebElement> activelinks=new ArrayList<WebElement>();
			for(int i=0;i<linklist.size();i++)
			{
				if(linklist.get(i).getAttribute("href")!= null)
            {
	           activelinks.add(linklist.get(i));
			}
			
		}
			System.out.println(activelinks.size());
			
			for(int j=0;j<activelinks.size();j++)
			{
				HttpURLConnection connection=(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
				connection.connect();
				String response=connection.getResponseMessage();
				connection.disconnect();
				
				System.out.println(activelinks.get(j).getAttribute("href")+"=="+response);
			}
}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
}