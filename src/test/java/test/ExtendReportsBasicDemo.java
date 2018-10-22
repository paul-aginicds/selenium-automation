package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("Google Search Test One",
				"This is a test to validate google search functionalty");

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");

		driver = new ChromeDriver();

		// log(Status, details)
		test.log(Status.INFO, "Starting Test Case");

		driver.get("https://google.com");
		test.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("AginicDS Paul Thornton");
		test.pass("Entered text in Searchbox");

		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test.pass("Pressed keyboard enter key");

		driver.close();
		driver.quit();
		test.pass("Closed the browser");

		test.info("Test Completed");

		System.out.println("Test Completed Successfully");

		// log with snapshot
		try {
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(projectPath +"/screenshot.png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test with snapshot
		try {
			test.addScreenCaptureFromPath(projectPath +"/screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// calling flush writes everything to the log file
		extent.flush();
	}
}
