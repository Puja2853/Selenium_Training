package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndBuyOrderFunctionality {

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
		driver.findElement(By.xpath("//a[@title='T-shirts']")).click();
		WebElement MoreBtn=driver.findElement(By.xpath("(//a[@class='product_img_link']/img)[1]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(MoreBtn).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");
		WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
		Select oSelect1=new Select(Sizedrpdwn);
		oSelect1.selectByVisibleText("L");
		driver.findElement(By.id("color_11")).click();
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

		driver.findElement(By.xpath("//*[@id='cgv']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

		String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']//p[@class='alert alert-success']")).getText();

		if(ConfirmationText.contains("complete")) {
			System.out.println("Product ordered successfully");
		}
		else {
			System.out.println("Order Not Successfull");
		}

	}
}
