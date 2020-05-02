import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {
	
	@Test
	public void TestAddition() throws MalformedURLException, InterruptedException {
				
		  Thread.sleep(10000); 
		  driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		  
		  driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
		  
		  driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		  
		  driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		  
		  Thread.sleep(3000); 
		  String str =  driver.findElement(By.id("com.android.calculator2:id/result")).getText().
		  toString();
		  System.out.println("The result is  "+str);
		  Assert.assertEquals("12", str);
					
		
	}
	
}