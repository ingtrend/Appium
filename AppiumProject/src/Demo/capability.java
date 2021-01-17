package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class capability {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		// when I am trying to run my program in a remote device
		// remote device is my emulator
		// I want to check do my emulator has this capability
		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Aish Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//this is not mandatory even if I remove this it will work// but for ios it will not work if you dont specify the automation name
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		//my first test will be on webapp
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		//there are specific capabilities
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:\\SDET\\Appium\\chromedriver_win32\\chromedriver.exe");
		//we write this// it will open browser in my local machine
		//WebDriver driver = new ChromeDriver();
		//We need to open browser in remote machine- emulator
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		return driver;

	}

}
