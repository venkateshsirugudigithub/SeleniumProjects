package com.amazon.onlineshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {

		this.driver = driver;
	}

	By txtSearchBox = By.xpath("//*[@id='twotabsearchtextbox']");
	By btnclick = By.xpath("//*[@id='nav-search']/form/div[2]/div/input");
	By lblNumOfItems = By.xpath("//*[@id='search']/span/div/span/h1/div/div[1]/div/div/span[1]");
	By titleOfThePage = By.xpath("//*[@id='merchandised-content']/div[1]/div[1]/div/h1");


	/**
	 * Get title of the page.
	 * 
	 * @return
	 * @throws InterruptedException
	 */

	
	public WebElement titleOfPage() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(titleOfThePage);
	}

	
	/**
	 * Searches number of books found in Books page.
	 * 
	 * @param nameofBook
	 * @return
	 */

	public String searchItemsWith(String nameofItem) {

		driver.findElement(txtSearchBox).sendKeys(nameofItem);
		driver.findElement(btnclick).click();
		String str = driver.findElement(lblNumOfItems).getText();
		String[] arr = str.split("of");
		return arr[1];

	}

	
}
