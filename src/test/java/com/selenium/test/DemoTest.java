package com.selenium.test;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoTest {
	 private WebDriver driver;
	 WebElement element,e5;
	 Wait<WebDriver> wait;
	 private String sessionId;
	  
	 @BeforeClass
	 public void Startup() throws Exception{
	  DesiredCapabilities capabillities = DesiredCapabilities.firefox();
        capabillities.setCapability("version", "5");
        capabillities.setCapability("platform", Platform.XP);
        capabillities.setCapability("name",  testName.getMethodName());
        this.driver = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabillities);
        this.sessionId = ((RemoteWebDriver)driver).getSessionId().toString();
	 }
	  
	@Test	
	public void GoogleLogin() throws Exception{
		 wait = new WebDriverWait(driver, 5000);
		driver.manage().window().maximize();
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://qa.ringdna.com/");
		
		element = driver.findElement(By.xpath("//a[@class='button blue']"));
		element.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));	
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoqa01@ringdna.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ebmdna0198");
		(driver.findElement(By.xpath("//input[@id='Login']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main-nav']/ul/li[1]/a[text()='Home']")));
		//wait.until(visibilityOfElementLocated(By.id("some_id")));
		

	}

	 @AfterClass
	 public void teardown(){
	   driver.quit();
	 }
}
