import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebNativeSwitching {

	@Test
	public void getFlights() throws InterruptedException, MalformedURLException {
		
		System.out.println("execution started.....");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability("chromedriverExecutable", "D:\\appium_jars\\chromedriver.exe");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 7.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		System.out.println("First context -->"+ driver.getContext());
		String context = driver.getContext(); // = "CHROMIUM"
		driver.context("NATIVE_APP");
		driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
		driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
		driver.context(context);
		
		driver.get("https://www.yatra.com/pwa/home.html?redirect=no");
		Thread.sleep(5000);
			
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		System.out.println("current context view -->"+driver.getContext());
		
		Set<String> views = driver.getWindowHandles();
		System.out.println("size of set -->" +views.size());
		
		driver.context("NATIVE_APP");

	//	driver.pressKey(AndroidKey.BACK);
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		driver.quit();
		
		
	}
	


}
