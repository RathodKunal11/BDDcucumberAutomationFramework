package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class CommanUtil{
	
	public static WebDriver driver;
	
	public CommanUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//Screen Shot
	
	public static void getscreenshot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   // capture the screenshot for you keep in selenium memory
		Date d = new Date();
		System.out.println(d);
		String filename = d.toString().replace(" ", "_").replace(":", "_")+".jpg";
		File dest = new File ("C:\\Users\\Admin - Dhwani\\eclipse-workspace\\YuvaCompassWeb\\ScreenShots"+filename);
		FileUtils.copyFile(src, dest);
	}
	
	// creating the boarder.==> Method which accepts the parameter but will not return anything.
	
		public static void borderbyJS(WebElement element) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		
		// capturing the title. ==> Method which accepts the parameter but will return title
		
		public static String titlebyJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String Title=js.executeScript("return document.title;").toString();
		return Title;
		}
		
		// click on element
		public static void clickbyJS(By locators) {
			WebElement element = driver.findElement(locators);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", element);
		}
		
		// generate userdefined alert.
		
		public static void alertbyJS(String message) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("alert('" + message + "')");
		}
		
		// refresh the page
		public static void refreshbyJS() {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("history.go(0)");
		}
		
		// Scrolling the page.
		
		public static void scrolldownbyJS(int x, int y) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("scroll("+x+","+y+")");    // scroll down	
		}
		
		public static void scrollupbyJS(WebDriver driver,int x, int y) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("scroll("+x+","+y+")");    // scroll up
		}
		
		// scroll into view.

		public static void scrollIntoViewbyJS(By locator) {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		}
		
		//Select Class
		
		public static void select(WebElement element,String optionName) throws InterruptedException {
			Select s=new Select(element);
			Thread.sleep(300);
			s.selectByVisibleText(optionName);
		}
		
		public static void select2(By locator,String optionName) {
			WebElement element = driver.findElement(locator);
			Select s=new Select(element);
			s.selectByVisibleText(optionName);
		}
		
		//Action class
		
		public static void ClickActionClass(WebElement element) {
			Actions action=new Actions(driver);
			action.click(element).build().perform();
		}
		
	
	
	//Handle Child window method
	
	public static void HandleChildWindow() {
		Set<String> windIDs = driver.getWindowHandles();
		Iterator<String> itr = windIDs.iterator();
		String parantWindID = itr.next();
		String childWindID = itr.next();
		driver.switchTo().window(childWindID);
	}
		
		


}
