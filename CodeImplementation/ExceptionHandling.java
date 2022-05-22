package codeImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("abc@cap.com");
		driver.findElement(By.id("Password")).sendKeys("1256");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		try {
			driver.findElement(By.linkText("Log out")).isDisplayed();
			System.out.println("login successful");
			driver.findElement(By.linkText("Log out")).click();
		}catch(NoSuchElementException e) {
			System.out.println("login unsuccessful");
		}
	}

}
