package com.amazon.onlineshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;

	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
		By lnkBooks = By.xpath("//*[@id='nav-xshop']/a[4]");
		By lnkElectronics = By.xpath("//*[text()='Electronics']");
		

		public WebElement booksTab() throws InterruptedException {
			Thread.sleep(3000);
			return driver.findElement(lnkBooks);
		}
		
		public WebElement electronicsTab() throws InterruptedException {
			Thread.sleep(3000);
			return driver.findElement(lnkElectronics);
		}


		
		
}
