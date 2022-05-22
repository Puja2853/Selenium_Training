package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndBuyOrderFunctionality {
	static WebDriver driver;




	@BeforeMethod
	public void before() {

	}


	@SuppressWarnings("deprecation")
	@Test

	public void EcomSignUp () throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);            
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);



		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("abcxyz@cap.com");
		driver.findElement(By.name("passwd")).sendKeys("xyz@123");	
		driver.findElement(By.id("SubmitLogin")).click();

		//Click on Women
		driver.findElement(By.linkText("WOMEN")).click();

		WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
		WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();


		//Change quantity by 2
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");

		//Select size as L
		WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
		Select oSelect1=new Select(Sizedrpdwn);
		oSelect1.selectByVisibleText("L");

		//Select Color
		driver.findElement(By.id("color_11")).click();

		//Click on add to cart
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();

		//Click on proceed
		driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();

		//Checkout page Proceed
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
		//Agree terms&Conditions
		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

		//Click on Payby Check
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
		//Confirm the order
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

		//Get Text
		String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();

		// Verify that Product is ordered
		if(ConfirmationText.contains("complete")) {
			System.out.println("Order Completed: Test Case Passed");
		}
		else {
			System.out.println("Order Not Successfull: Test Case Failed");
		}
		driver.close();
	}

}
