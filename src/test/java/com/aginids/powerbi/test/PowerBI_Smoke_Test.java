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

public class PowerBI_Smoke_Test {

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
	 */
	 
	  @Test
	  public void testArrivalFilters() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[4]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[4]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	  }
	  
	  
	  

	  @Test
	  public void testVisitType() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[6]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dead on Arrival'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dead on Arrival'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Emergency Presentation'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Emergency Presentation'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Patient in transit'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Patient in transit'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pre-arranged admission'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pre-arranged admission'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[1]/following::div[8]")).click();
	  }
	  
	


	  @Test
	  public void testDiagnosis() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[12]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[9]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Abdominal / Flank pain/cramps / Intestinal Colic'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[1]/following::div[8]")).click();
	  }


	  

	  @Test
	  public void testInsuranceType() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[8]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Unknown Compensable Status'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Transport Accident Commission'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Prisoner'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Overseas eligible/Ineligible hospital exempt'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Medicare Patient'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ineligible not compensable'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ineligible not compensable'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[1]/following::div[8]")).click();
	  }
	  
	  

	  @Test
	  public void testReferralSource() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[14]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Staff from this campus'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Staff from another campus'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Self, family, friends'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Own Local Medical Officer'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Own Local Medical Officer'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[1]/following::div[8]")).click();
	  }

	  @Test
	  public void testCareGroup() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[16]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[11]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cardiac Monitored'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fast Track'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[1]/following::div[8]")).click();
	  }
	  
	  /*
	  @Test
	  public void testCase2() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[8]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[5]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Air Ambulance - Fixed Wing'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ambulance Private - hospital'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ambulance Private - MAS/RAV'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Other - Private Car/Walking'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Other - Private Car/Walking'])[1]/following::span[1]")).click();
	  }
	
	  @Test
	  public void testCase3() throws Exception {
	    driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[4]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[5]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Abortion, incomplete without complications'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Abscess of labia or vulva'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Abscess of labia or vulva'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[4]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[10]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Undertaker'])[1]/following::span[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dead on Arrival'])[3]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Emergency Presentation'])[2]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Emergency Presentation'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[2]/following::div[3]")).click();
	  }
  
	  
	  
	@Test
	public void testPowerBIapp() throws Exception {
		
		test = extent.createTest("PowerBI Test", "PowerBI Smoke Test Demo");
		
		
		driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
		test.pass("Navigated to app.powerbi.com demo dashboard");
		Thread.sleep(1000); 
		
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[16]/following::div[3]")).click();
	    test.pass("Checking 'Arrival Mode' - Filter Test 1");	    
	    
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[9]")).click();
	    test.pass("Checking 'Arrival Mode' - Filter Test 2");	    

	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[9]")).click();
	    test.pass("Checking 'Arrival Mode' - Filter Test 3");	    
	    
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Air Ambulance])[1]/following::span[1]")).click();
	    test.pass("Checking 'Arrival Mode' - Filter Test 4");	    
	    
	    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Air Ambulance - Fixed Wing'])[1]/following::span[1]")).click();
	    test.pass("Checking 'Arrival Mode' - Filter Test 5");	    
	    
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ambulance Private - hospital'])[1]/following::span[1]")).click();
	    test.pass("Checking 'Arrival Mode' - Filter Test 6");	    
	    
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ambulance Private - hospital'])[1]/following::span[1]")).click();
	    test.pass("Checking 'Arrival Mode' - Filter Test 7");	    
		
		
		//test.log(Status.INFO, "This step shows usage of log(status, details)");
        //test.info("This step shows usage of info(details)");
        //Assert.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        //test.addScreenCaptureFromPath("screenshot.png");
	}
	*/
		
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
