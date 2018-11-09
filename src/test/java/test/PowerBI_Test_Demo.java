package test;


import java.util.regex.Pattern;
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

public class PowerBI_Test_Demo {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	
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
	
	@Test
	public void testPowerBIapp() throws Exception {
		
		ExtentTest test = extent.createTest("PowerBI Test", "PowerBI Smoke Test Demo");
		
		
		driver.get("https://app.powerbi.com/view?r=eyJrIjoiM2VjMDVmZmMtNmMzNi00ZTM3LTgyNWUtODdlNWE0NTA5OTczIiwidCI6IjdhN2U1NDFjLTA1N2YtNDUxNi04ZTcyLTI1ODk1OTA3ZGI3NiIsImMiOjEwfQ%3D%3D");
		
		test.pass("Navigated to app.powerbi.com demo dashboard");

		
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='List'])[16]/following::div[3]")).click();
	    test.pass("Test step 2");	    
	    
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[9]")).click();
	    test.pass("Test step 3");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[9]")).click();
	    test.pass("Test step 4");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Air Ambulance - Fixed Wing'])[1]/following::span[1]")).click();
	    test.pass("Test step 5");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Air Ambulance - Fixed Wing'])[1]/following::span[1]")).click();
	    test.pass("Test step 6");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ambulance Private - hospital'])[1]/following::span[1]")).click();
	    test.pass("Test step 7");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ambulance Private - hospital'])[1]/following::span[1]")).click();
	    test.pass("Test step 8");
		
		
		//test.log(Status.INFO, "This step shows usage of log(status, details)");
        //test.info("This step shows usage of info(details)");
        //Assert.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        //test.addScreenCaptureFromPath("screenshot.png");
	}
		
	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit();
		System.out.println("PowerBI Automated Test Completed Successfully");
	}
	
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
		
	}
	
}
