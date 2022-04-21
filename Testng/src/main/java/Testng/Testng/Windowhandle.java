package Testng.Testng;


import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Windowhandle {

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
	@Test
	public void manageWindow() throws InterruptedException
	{
		Point position=driver.manage().window().getPosition().moveBy(1, 200);
		driver.manage().window().setPosition(position);
		
		Dimension d=driver.manage().window().getSize();
		System.out.println(d);
		int h=driver.manage().window().getSize().getHeight();
		int w=driver.manage().window().getSize().getWidth();
		System.out.println("height is "+h+" & "+"width is "+w);
		
		Point windowPosition = driver.manage().window().getPosition();
        System.out.println("Window Position for Current Window");
        System.out.println("Window X position: " + windowPosition.getX());
        System.out.println("Window Y position: " + windowPosition.getY());
        Thread.sleep(500);
        
        Point newWindowPosition = windowPosition.moveBy(400, 300);
        driver.manage().window().setPosition(newWindowPosition);
        System.out.println("Window Position for Current Window");
        System.out.println("Window X position: " + driver.manage().window().getPosition().getX());
        System.out.println("Window Y position: " + driver.manage().window().getPosition().getY());
        Thread.sleep(500);
	}
	@Test(priority=2)
	public void windowhandles() throws InterruptedException
	{
		driver.navigate().to("https://www.kotak.com/en/home.html");
	String parent=driver.getWindowHandle();
	System.out.println("current window handle "+parent);
		driver.findElement(By.className("login-btn")).click();
	Set<String>	handles=driver.getWindowHandles();
	System.out.println("handles count "+handles.size());
	for(String handle:handles)
	{
		System.out.println(handle);
		if(!handle.equals(parent))
		{
			driver.switchTo().window(handle);
			Thread.sleep(2000);
			driver.switchTo().window(parent);
			Thread.sleep(2000);
		}
	}
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
