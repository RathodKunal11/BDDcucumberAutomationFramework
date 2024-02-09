package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughWork {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bfaasaan.dhwaniris.in/");
		driver=DriverFactory.initialization();
		driver.findElement(By.id("loginform-username")).sendKeys("admin");
		driver.findElement(By.id("loginform-password")).sendKeys("NRI@Bright2022");
		driver.findElement(By.xpath("//button[@name='login-button']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bandhan')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Alumni')]")).click();
		List<WebElement> BandhanAppDDoptions = driver.findElements(By.xpath("//ul[@id='w12']//li"));
		
		for (int i = 0; i < BandhanAppDDoptions.size(); i++) {
			WebElement option = BandhanAppDDoptions.get(i);
			if (option.getText().equalsIgnoreCase("Alumni")) {
				option.click();
				break;
			}
		}
		
		setDOB("01","January","1996");
		}
		
		
		
	public static void setDOB(String day,String month,String year) {
		driver.findElement(By.xpath("//a[@class='btn btn-blue']")).click();
		System.out.println("clicked on calendor");
		driver.findElement(By.id("bandhanstudent-dob")).click();
		System.out.println("clicked on DOB");		
		driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-years']//th[@class='datepicker-switch']")).click();
		setValue(year);
		setValue(month);
		setValue(day);
		
	}

	public static void setValue(String val) {
		List<WebElement> years = driver.findElements(By.xpath("//div[@class='datepicker-years']//span"));
		int i;
		for(i=0;i<years.size();i++) {
			if(years.get(i).getText().equalsIgnoreCase(val)){
				years.get(i).click();break;
			}
		}
		if(years.size()==i) {
			driver.findElement(By.xpath("//div[@class='datepicker-years']//th[@class='prev']")).click();
			setValue(val);
		}	
	}
		
		
		
		
//		driver.findElement(By.xpath("//a[@class='btn btn-blue']")).click();
//		WebElement selectLanguageDD = driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered']//input)[3]"));
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].scrollIntoView(true);",selectLanguageDD);
//		selectLanguageDD.click();
//		Actions action=new Actions(driver);
//		action.keyDown(Keys.CONTROL).build().perform();
//		
//		List<WebElement> languageOptions = driver.findElements(By.xpath("//ul[contains(@id,'language-results')]//li"));
//		String str="English,Hindi,Marathi";
//		String[] options = str.split(",");
//		
//		
//		for (String option : options) {
//		    for (WebElement languageOption : languageOptions) {
//		        String languageText = languageOption.getText();
//		        if (languageText.equalsIgnoreCase(option)) {
//		            languageOption.click();
//		            break; // Exit the inner loop once the option is found and clicked
//		        }
//		    }
//		}
//		
	

	
//	public void selectDate(String day,String month,String year) {
//		driver.findElement(By.id("bandhanstudent-dob")).click();
//		int i=3;
//		while(i<3) {
//		driver.findElement(By.xpath("//th[@class='datepicker-switch']")).click();
//		i--;
//		}
}