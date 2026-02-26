package jenkinsTest;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;



public class DemoJenkisTest {


	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setup() {
		io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
		org.openqa.selenium.edge.EdgeOptions options = new org.openqa.selenium.edge.EdgeOptions();
	    options.addArguments("--headless");
		options.addArguments("--disable-gpu");
    	options.addArguments("--window-size=1920,1080");
		
		driver = new org.openqa.selenium.edge.EdgeDriver(options);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test
	public void login() {
		WebElement username=wait.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
		username.sendKeys("standard_user");
		
		WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		password.sendKeys("secret_sauce"+Keys.ENTER);
		
	
		}
			
		
	
	@AfterMethod
	public void quit() {
		driver.quit();
}
}
