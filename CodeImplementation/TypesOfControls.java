package codeImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TypesOfControls {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("abcxyz2@cap.com");
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys("abc");
		driver.findElement(By.name("customer_lastname")).sendKeys("xyz");
		Thread.sleep(2000);
		driver.findElement(By.id("passwd")).sendKeys("xyz@123");
		driver.findElement(By.id("firstname")).sendKeys("abc");
		driver.findElement(By.id("lastname")).sendKeys("xyz");
		driver.findElement(By.id("company")).sendKeys("Capgemini");
		driver.findElement(By.id("address1")).sendKeys("S.no70/A5, xyyy");
		driver.findElement(By.id("city")).sendKeys("Pune");
		Thread.sleep(2000);
		
		WebElement statedropdown = driver.findElement(By.name("id_state"));
		Select s =new Select(statedropdown);
		s.selectByValue("5");
		Thread.sleep(3000);
		
		driver.findElement(By.name("postcode")).sendKeys("41192");
		
		WebElement countrydropDown = driver.findElement(By.name("id_country"));
		Select s2 = new Select(countrydropDown);
		s2.selectByVisibleText("United States");
		Thread.sleep(2000);
		
		driver.findElement(By.id("phone_mobile")).sendKeys("9876547856");
		Thread.sleep(2000);
		driver.findElement(By.name("submitAccount")).click();
		Thread.sleep(2000);
		
		 String user = driver.findElement(By.xpath("//*[@id='header']")).getText();
		   if(user.contains("abc xyz")) {
		    System.out.println("User Verified");
		   }
		   else {
		    System.out.println("User Verification Failed");
		   }
		   
		   driver.close();

	}

}
