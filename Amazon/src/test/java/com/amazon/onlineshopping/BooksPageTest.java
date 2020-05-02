package com.amazon.onlineshopping;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.onlineshopping.pages.Base;
import com.amazon.onlineshopping.pages.BooksPage;
import com.amazon.onlineshopping.pages.LandingPage;

public class BooksPageTest extends Base{

	
	@BeforeTest
	public void intiDriver() throws IOException, InterruptedException {
		
		driver=initializeDriver();
		driver.navigate().to("http://www.amazon.co.uk");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testBooksPageTitle() throws IOException, InterruptedException {
		LandingPage lp = new LandingPage(driver);
		lp.booksTab().click();
		BooksPage bp = new BooksPage(driver);
		System.out.println(bp.titleOfPage().getText());
		Assert.assertEquals("Books", bp.titleOfPage().getText());
	}
	
	@Test
	public void testBooksPageSearch() throws IOException, InterruptedException {
		LandingPage lp = new LandingPage(driver);
		lp.booksTab().click();
		BooksPage bp = new BooksPage(driver);
		String strNumOfBooksFound = bp.searchItemsWith("Selenium books");
		System.out.println(strNumOfBooksFound);
		Assert.assertEquals(true, strNumOfBooksFound.contains("842"));
		
	}
	
	
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
	
	
	
}
