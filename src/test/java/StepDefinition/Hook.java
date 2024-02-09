package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Context.TestContext;
import Utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hook {

	private WebDriver driver;
	private final TestContext context;
	
	public Hook(TestContext context) {
		this.context=context;
	}
	
	@Before
	public void before(Scenario scenario) {
		System.out.println("BEFORE:THREAD ID:"+Thread.currentThread().getId()+","+"SCENARIO NAME"+ scenario.getName());
		Allure.step("Browser launched.");
		driver=DriverFactory.initialization();
		driver.findElement(By.id("loginform-username")).sendKeys("admin");
		driver.findElement(By.id("loginform-password")).sendKeys("NRI@Bright2022");
		driver.findElement(By.xpath("//button[@name='login-button']")).click();
		context.driver=driver;
	}
	
//	@After
//	public void after(Scenario scenario) {
//	System.out.println("BEFORE:THREAD ID:"+Thread.currentThread().getId()+","+"SCENARIO NAME"+ scenario.getName());
//	Allure.step("Browser launched.");
//	driver.quit();
//		Allure.step("browser closed.");
//	}
		

}
