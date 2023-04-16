package takeScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetScreenShot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		//Full page
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\homepage.png");
		
		FileUtils.copyFile(src, trg);
		
		//screenshot of section/portion of the page
		//makesure comment out full page screenshot in order to do run next code
		
		WebElement section = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='pageContent']/div[@id='desktop-banner']/div[@id='gw-desktop-herotator']/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[2]/div[1]/div[1]/div[1]/div[1]/a[1]"));
		
		//File src = section.getScreenshotAs(OutputType.FILE);
		//File trg = new File(".\\screenshots\\featuresproduct.png");
		
		FileUtils.copyFile(src, trg);
		
		
		driver.close();
		

	}

}
