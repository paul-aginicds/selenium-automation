package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo {

	WebDriver driver = null;

	
	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();

	}

	@Test
	public void googleSearch() {

		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("Automate Step by Step");

		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

	}
	
	
	@AfterTest
	public void tearDownTest() {

		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
}
