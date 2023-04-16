package actionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		Thread.sleep(3000L);
		
		WebElement positionXpath = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement destinationXpath = driver.findElement(By.xpath("//div[@id='box106']"));
		
		Actions act = new Actions(driver);
		
		Thread.sleep(3000L);
		
		act.clickAndHold(positionXpath).moveToElement(destinationXpath).release().perform();
		
	
		Thread.sleep(3000L);
		driver.close();

	}

}
