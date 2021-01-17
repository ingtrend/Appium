package Demo;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class web1 extends capability{
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException
	{
		//AndroidDriver<AndroidElement> driver = capabilities();
		driver = capabilities();
		//if any of my element takes time it will wait for extra 30 secs
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@Test
	public void testcase1() throws InterruptedException
	{
		driver.get("http://www.google.com");
		// or driver.navigate().to("http://www.google.com")	
		// this will search for IBM in search
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
		//I have to click and search for IBM
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.RETURN);
		//I want to find out how many links are there
		Thread.sleep(3000);
		List<AndroidElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		//I want  to fetch the text of all links
		for(int i=0; i<links.size();i++)
		{
			//print the names of the links
			System.out.println(links.get(i).getText());
		}
		//I want to scroll and click on any link IBM wiki,
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'IBM - Wikipedia')]"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		ele.click();
		
		
	}

	}
