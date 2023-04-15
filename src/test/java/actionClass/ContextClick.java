package actionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement copyXpath = driver.findElement(By.xpath("//span[text()='Copy']"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(rightClick).perform();
		Thread.sleep(3000L);
		copyXpath.click();
		
		
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();	
		Thread.sleep(5000L);
		
		driver.close();
		

	}

}
