package com.amazon.onlineshopping.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

public	WebDriver driver;
	
	
	/**
	 *  Initialize WebDriver
	 *  @throws IOException
	 */
	
	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("config.properties");
		prop.load(fi);
		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\drivers\\chromedriver.exe");

		if (browserName.contentEquals("chrome")) {
			
			//  For Headless mode
			//	ChromeOptions options = new ChromeOptions();
			//	options.addArguments("--headless");
			
			driver = new ChromeDriver();
			
			
		} else if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;

	}

}
