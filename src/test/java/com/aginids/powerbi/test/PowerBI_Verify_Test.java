package com.aginids.powerbi.test;


import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PowerBI_Verify_Test {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentTest test;
	private StringBuffer verificationErrors = new StringBuffer();
	
	WebDriver driver;
	
	@BeforeMethod
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("reports/PowerBI_Test_Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
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
	/*
	 @Test
	  public void testNoEpisodes() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    
	    String episodes = driver.findElement(By.cssSelector("text.value")).getText();
	    
	    System.out.println(episodes);
	  }
	 */
	
	  @Test
	  public void testNoEpisodes() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    try {
	      assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Arrivals by Hour and Triage'])[1]/following::span[1]")).getText(), "Admissions");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals(driver.findElement(By.cssSelector("text.value")).getText(), "399K399K");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals(driver.findElement(By.xpath("//div[@id='pvExplorationHost']/div/div/div/div[2]/div/div[2]/div[2]/div[8]/div[3]/div[2]/div/div/div/text")).getText(), "Triage 0 - Mental Health");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }	 

	 
		
	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit();
		//test.pass("PowerBI automated test completed successfully! :)");
	}
	
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		
		//extent.flush();
		
	}
	
}
