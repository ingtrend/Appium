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
	
	public class Assignment extends capability{
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
			driver.get("http://www.cricbuzz.com");
			// this will click on Menu button
			driver.findElement(By.xpath("//span[normalize-space()='Menu']")).click();
			//I have to click on Home button
			driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
			//I want to scroll to Top Stories,
			Thread.sleep(6000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement ele = driver.findElement(By.xpath("//h4[normalize-space()='Top Stories']"));
			js.executeScript("arguments[0].scrollIntoView()", ele);
			ele.isDisplayed();			
		}


}
