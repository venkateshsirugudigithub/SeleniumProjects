package com.amazon.onlineshopping;

import java.io.IOException;
import org.testng.annotations.Test;

import com.amazon.onlineshopping.pages.Base;


public class Temp extends Base{
	
		
	@Test
	public void testingEnvi() throws IOException, InterruptedException {
		
		driver= initializeDriver();	
		driver.navigate().to("http://www.amazon.co.uk");
		Thread.sleep(5000);
		driver.quit();
	}

}
