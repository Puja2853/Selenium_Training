package codeImplementation;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecution {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String title=js.executeScript("return document.title").toString();
		System.out.println("title of page is " + title);
		
		String url=js.executeScript("return document.URL").toString();
		System.out.println("url of application is " + url);
		
		String domain=js.executeScript("return document.domain").toString();
		System.out.println("domain of application is " + domain);
		Thread.sleep(3000);
		
		js.executeScript("window.location='http://www.youtube.com'");
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(2000);
		

	}

}
