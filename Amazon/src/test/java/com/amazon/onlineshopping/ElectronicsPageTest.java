package com.amazon.onlineshopping;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.onlineshopping.pages.Base;
import com.amazon.onlineshopping.pages.ElectrionicsPage;
import com.amazon.onlineshopping.pages.LandingPage;

public class ElectronicsPageTest extends Base{
	

	@BeforeTest
	public void intiDriver() throws IOException, InterruptedException {
		
		driver=initializeDriver();
		driver.navigate().to("http://www.amazon.co.uk");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testElectronicsPageTitle() throws IOException, InterruptedException {
	
		LandingPage lp = new LandingPage(driver);
		lp.electronicsTab().click();
		ElectrionicsPage bp = new ElectrionicsPage(driver);
		System.out.println(bp.titleOfPage().getText());
		Assert.assertEquals("The Electronics Store", bp.titleOfPage().getText());
	}
	
	
	@Test
	public void testElectronicsPageSearch() throws IOException, InterruptedException {
		LandingPage lp = new LandingPage(driver);
		lp.electronicsTab().click();
		ElectrionicsPage bp = new ElectrionicsPage(driver);
		
		// Verify search results
		String strNumOfBooksFound = bp.searchItemsWith("Amazon Kindle");
		System.out.println(strNumOfBooksFound);
		Assert.assertEquals(true, strNumOfBooksFound.contains("23"));

		// verify eBooks Reader link displayed on the page
		boolean flag = bp.isLinkeBooksReaderPresent();
		Assert.assertEquals(true, flag);
		
	}
	
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
	

}
