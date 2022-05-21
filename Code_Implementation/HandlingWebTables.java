package codeImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTables {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();

		int Row = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
		System.out.println("Total row: " + Row);
		int Col = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/th")).size();
		System.out.println("Total column: " + Col);

		for(int i=2; i<=Row; i++) {
			for(int j =1; j<=Col; j++) {
				System.out.print(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td["+j+"]")).getText() + " | ");
			}
			System.out.println();
		}
		System.out.println();

		WebElement cell = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[7]/td[3]"));
		String value = cell.getText();
		System.out.println("The Cell Value is : " + value);

	}

}
