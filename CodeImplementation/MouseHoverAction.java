package codeImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		
		WebElement computer=driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(computer).build().perform();
		Thread.sleep(3000);
		
		WebElement notebook=driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Notebooks')]"));
		act.moveToElement(notebook).click().perform();
		Thread.sleep(3000);
		
		WebElement electronic=driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Electronics')]"));
		Actions act1=new Actions(driver);
		act1.moveToElement(electronic).build().perform();
		Thread.sleep(300);
		WebElement cellphone=driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Cell phones')]"));
		act1.moveToElement(cellphone).click().perform();

	}

}
