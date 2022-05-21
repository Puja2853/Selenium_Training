package codeImplementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDown {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("abcxyz@cap.com");
		driver.findElement(By.name("passwd")).sendKeys("xyz@123");	
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.linkText("WOMEN")).click();
		driver.findElement(By.partialLinkText("Casual")).click();
		
		WebElement sort = driver.findElement(By.id("selectProductSort"));
		Select s = new Select(sort);
		s.selectByIndex(2);
		Thread.sleep(2000);
		
		driver.close();

	}

}
