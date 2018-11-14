package com.aginids.powerbi.test;


import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class PowerBI_PageSwitch_Test {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {

	}
	 
	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		
		System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver/geckodriver");
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");		
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}  
	  @Test
	  public void testPageSwitching() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    //driver.findElement(By.xpath("//div[@id='pbiAppPlaceHolder']/ui-view/div[2]/div/div/logo-bar-navigation/span/a[3]/i")).click();
	    
	    WebElement element = driver.findElement(By.xpath("//div[@id='pbiAppPlaceHolder']/ui-view/div[2]/div/div/logo-bar-navigation/span/a[3]/i"));

	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	  }
		
	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit();
	}

	
}
