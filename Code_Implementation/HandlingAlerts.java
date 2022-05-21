package codeImplementation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		
		driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Alert alert1 = driver.switchTo().alert();
		String text = alert1.getText();
		System.out.println(text);
		Thread.sleep(3000);
		alert1.dismiss();
		
		driver.findElement(By.partialLinkText("Alert with Textbox")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Puja");
		Thread.sleep(3000);
		alert2.accept();
	}

}
