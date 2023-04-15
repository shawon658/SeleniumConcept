package actionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		WebElement mouseOver = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(mouseOver).perform();
		
		Thread.sleep(5000L);
		
		driver.findElement(By.xpath("//span[text()='Create a List']")).click();
		
		Thread.sleep(3000L);
		
		driver.close();		
		

	}

}
