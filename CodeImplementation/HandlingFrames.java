package codeImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();

		//driver.switchTo().frame(name of the frame or id of the frame);
		//driver.switchTo().frame(as a WebElement or index number);

		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("/html/body/main/ul/li[5]/a")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("/html/body/main/div/section/ul/li[2]/a")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.switchTo().frame("classFrame");
		driver.findElement(By.cssSelector("#search")).sendKeys("Method");
		Thread.sleep(3000);

		driver.close();

	}

}
