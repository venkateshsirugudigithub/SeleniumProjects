package com.amazon.onlineshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectrionicsPage extends BasePage{

	public WebDriver driver;

	public ElectrionicsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	By lnkeBookReader = By.xpath("//*[text()='eBook Readers']");
	
	
	public boolean isLinkeBooksReaderPresent() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lnkeBookReader));		
		boolean flag = driver.findElement(lnkeBookReader).isDisplayed();
		return flag;	
	}
		

}
