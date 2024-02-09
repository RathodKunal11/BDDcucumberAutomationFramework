package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory {

	
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public static WebDriver initialization() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bfaasaan.dhwaniris.in/");
		DriverFactory.driver.set(driver);
		
		return driver;
		
	}
	
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	

}
