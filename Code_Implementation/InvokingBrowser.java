package codeImplementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingBrowser {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup(); //for specific version of browser
		//WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



	}

}
