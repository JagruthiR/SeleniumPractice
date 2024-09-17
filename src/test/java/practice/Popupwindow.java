package practice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Popupwindow {
 
	public WebDriver driver;
	
	@Test
  public void  Windowpopup() throws Exception {
 
		//Clicks on Separate windows
				driver.findElement(By.xpath("//a[normalize-space()='Open New Seperate Windows']")).click();
				
				Thread.sleep(3000);
				
				// Click_button
				driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'click')]")).click();
				
				Thread.sleep(3000);
				
				//come back to Parent window handle
				String backtoParentwinow = driver.getWindowHandle();
			
			 

				  //handling Child window 
				  for(String childwindowhandle : driver.getWindowHandles()) {
				  
				  //Switch to Child window 
				 driver.switchTo().window(childwindowhandle);
				 
				 
				  }
				 
				driver.manage().window().maximize();
		         Thread.sleep(3000);

				// Clicks on Blog_Button
				driver.findElement(By.xpath("//span[contains(text(),'Blog')]")).click();
		        Thread.sleep(3000);
		       
		        //Child window closed
				driver.close();

				Thread.sleep(3000);

				// Again Switch focus back to Parent window
				driver.switchTo().window(backtoParentwinow);
		        Thread.sleep(5000);

				// Clicks on Home_Button
				driver.findElement(By.linkText("Home")).click();
				Thread.sleep(3000);
				
  
  
  
  }
	
	
  @BeforeTest
  public void beforeTest() {
  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		  driver.get("http://demo.automationtesting.in/Windows.html");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
  
  
  }

  @AfterTest
  public void afterTest() {

  
      driver.close();
  
  }

}
