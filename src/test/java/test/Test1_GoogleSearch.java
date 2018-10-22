package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		
		googleSearch();

	}

	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver");

		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automate Step by Step");
		
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		
		
		driver.close();
		
		System.out.println("Test Completed Successfully");
		
		
	}
}
