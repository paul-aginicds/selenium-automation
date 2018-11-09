package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AginicDS_SmokeTest_Demo {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	 
	WebDriver driver;
	
	@BeforeMethod
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("reports/AginicDS_SmokeTest_Report.html");
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
	public void testAginicDS_SmokeTest() throws Exception {
		
		ExtentTest test = extent.createTest("AginicDS Smoke Test", "Smoke test of aginicds.com");
		
		driver.get("http://aginicds.com");
		test.pass("Navigated to aginicds.com");

		driver.findElement(By.xpath("//a[contains(text(),'What we offer')]")).click();       
		test.pass("Checking section 'What we offer' - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'Digital transformation')]")).click();       
		test.pass("Checking section '' - step successful.");
		
		driver.findElement(By.xpath("//a[contains(text(),'What we offer')]")).click();       

		driver.findElement(By.xpath("//a[contains(text(),'Sustainable, scalable agile delivery')]")).click();       
		test.pass("Checking section '' - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'What we offer')]")).click();       
		test.pass("Checking section '' - step successful.");
		
		driver.findElement(By.xpath("//a[contains(text(),'Building great products & experiences')]")).click();       
		test.pass("Checking section '' - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'What we offer')]")).click();       

		driver.findElement(By.xpath("//a[contains(text(),'Successful delivery leadership')]")).click();       
		test.pass("Checking section '' - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'What we offer')]")).click();       
		
		driver.findElement(By.xpath("//a[contains(text(),'Understanding agile techniques')]")).click();       
		test.pass("Checking section '' - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'What we offer')]")).click();       
		test.pass("Checking section '' - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'Community events')]")).click();       
		test.pass("Checking section '' - step successful.");
		
		driver.findElement(By.xpath("//a[contains(text(),'What we offer')]")).click();       
		test.pass("Checking section 'What we offer' - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'Our stories')]")).click();       
		test.pass("Checking section '' - step successful.");
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Delivery Benefits through Pair Programming')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		test.pass("Checking blog post - step successful.");

		driver.findElement(By.xpath("//a[contains(text(),'Our stories')]")).click();   
		test.pass("Checking section '' - step successful.");
		
	}
		
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Smoke test completed successfully :)");
	}
	
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
		
	}
	
}
