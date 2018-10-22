package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
    //private static ThreadLocal parentTest = new ThreadLocal();
    //private static ThreadLocal test = new ThreadLocal();
	
	WebDriver driver;
	
	@BeforeMethod
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() throws Exception {
		
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		
		driver.get("https://google.com");
		test.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("AginicDS Paul Thornton");
		test.pass("Entered text in Searchbox");

		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test.pass("Pressed keyboard enter key");
         
		
		test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        //Assert.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        //test.addScreenCaptureFromPath("screenshot.png");
	}
		
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
		
	}
	
}
