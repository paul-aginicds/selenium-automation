package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		googleSearch();

	}

	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();

		driver.get("https://google.com");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Automate Step by Step");
		GoogleSearchPage.button_search(driver).sendKeys(Keys.ENTER);
		
		driver.close();
		
		System.out.println("Test Completed Successfully");
		
		
	}
}
