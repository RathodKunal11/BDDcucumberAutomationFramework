package StepDefinition;



import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import Context.TestContext;
import PageObjects.CreateAlumniPage;
import Utilities.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class CreateAlumniStepDefinition {
	
	private WebDriver driver;
	public CreateAlumniPage alumniPage;
	
	
	
	public CreateAlumniStepDefinition(TestContext context) {
		driver=context.driver;
		alumniPage=context.alumniPage;
	}
	
	@Given("user is on alumni landing page")
	public void user_is_on_alumni_landing_page() {
//		driver=DriverFactory.getDriver();
		
		alumniPage=new CreateAlumniPage(driver);
		alumniPage.ExpandBandhanAppDropDown();
		alumniPage.locateAndClickOnAlumniOption();
		Allure.step("allumni landing page");
		
	}

	@When("user clicks on the create alumni button")
	public void user_clicks_on_the_create_alumni_button() {
//		CreateAlumniPage alumniPage=new CreateAlumniPage(driver);
	   
		alumniPage.clickonCreateBtn();
	}

	@And("enters the data {string} and {int} into all mandatory fields")
	public void enters_the_data_and_into_all_mandatory_fields(String SheetName, Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
		
		alumniPage.FillCreateAlumniForm(SheetName, RowNum);
	
	}

	@And("click on the create button")
	public void click_on_the_create_button() {
	   
		
	}

	@Then("alumni record should be display in the first row of alumni detail table")
	public void alumni_record_should_be_display_in_the_first_row_of_alumni_detail_table() {
	   
		
	}

}
