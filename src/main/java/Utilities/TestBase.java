package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

public WebDriver driver;
	
	public WebDriver WebDriverManager() {
		
		if(driver==null) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get("https://stgbrightfuture.dhwaniris.in/site/login");
		driver.findElement(By.id("loginform-username")).sendKeys("admin");
		driver.findElement(By.id("loginform-password")).sendKeys("NRI@Bright2022");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		}
		return driver;
	}
	public void close() {
		driver.close();
	}
}
