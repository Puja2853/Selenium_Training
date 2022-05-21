package codeImplementation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		List<WebElement> links= driver.findElements(By.tagName("a")); 
		System.out.println(links.size());


		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("abcxyz@cap.com");
		driver.findElement(By.name("passwd")).sendKeys("xyz@123");	
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("#search_query_top")).sendKeys("Dress");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		driver.findElement(By.partialLinkText("List")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Sign out")).click();
		driver.close();


	}

}
