 package PageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;

import Utilities.CommanUtil;
import Utilities.DriverFactory;
import Utilities.ExcelReader;
import Utilities.ExcelUtil;

public class CreateAlumniPage extends BasePage{
	public static WebDriver driver;
	
	
	public CreateAlumniPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//ul[@id='w1']//li)[37]") private WebElement BandhanAppDD;
	@FindBys({@FindBy(xpath ="(//ul[@id='w1']//li)[37]//li")}) private List<WebElement> BandhanAppDDoptions;
	
	@FindBy(xpath="//a[@class='btn btn-blue']") private WebElement CreateAlumniBtn;
	
	//create Alumni form
	@FindBy(id="bandhanstudent-registration_id") private WebElement AlumniID;
	@FindBy(id="bandhanstudent-first_name") private WebElement FirstName;
	@FindBy(id="bandhanstudent-last_name") private WebElement LastName;
	@FindBy(id="bandhanstudent-password") private WebElement Password;
	@FindBy(id="bandhanstudent-confirm_password") private WebElement ConfirmPassword;
	@FindBy(id="bandhanstudent-state_id") private WebElement StateDD;
	@FindBy(id="bandhanstudent-district_id") private WebElement DistrictDD;
	@FindBy(id="bandhanstudent-block") private WebElement Block;
	@FindBy(id="bandhanstudent-pincode") private WebElement PinCode;
	@FindBy(id="bandhanstudent-dob") private WebElement DOBCalender;
	@FindBy(id="bandhanstudent-age") private WebElement Age;
	@FindBy(id="bandhanstudent-gender") private WebElement GenderDD;
	@FindBy(id="bandhanstudent-educational_qualification") private WebElement EducationDD;
	@FindBy(id="bandhanstudent-pursuing_education_id") private WebElement PursuingEducationDD;
	@FindBy(id="bandhanstudent-marital_status") private WebElement MartialStatusDD;
	@FindBy(id="bandhanstudent-any_disability") private WebElement DisabilityDD;
	@FindBy(id="bandhanstudent-profile_pic") private WebElement ProfilePic;
	@FindBy(id="bandhanstudent-center_id") private WebElement CenterDD;
	@FindBy(id="bandhanstudent-batch_id") private WebElement BatchDD;
	@FindBy(id="bandhanstudent-financial_year_id") private WebElement FinancialYearDD;
	@FindBy(id="bandhanstudent-email") private WebElement EmailID;
	@FindBy(id="bandhanstudent-mobile_no") private WebElement MobileNo;
	@FindBy(id="bandhanstudent-current_address") private WebElement CurrentAddress;
	@FindBy(xpath="//input[contains(@placeholder,'Skills')]") private WebElement selectSkillsField;
	@FindBys({@FindBy(xpath ="//ul[contains(@id,'skills-results')]//li")}) private List<WebElement> SkillOptions;
	@FindBy(xpath="//input[@class='select2-search__field'])[2]") private WebElement SkillsMSDD;
	@FindBy(xpath="//input[@class='select2-search__field'])[3]") private WebElement LanguageMSDD;
	@FindBy(id="bandhanstudent-uploaded_aadhar_card") private WebElement UploadAdhaar;
	@FindBy(id="bandhanstudent-uploaded_pan_card") private WebElement UploadPan;
	@FindBy(id="bandhanstudent-uploaded_birth_certificate") private WebElement UploadBirthCertificate;
	@FindBy(id="bandhanstudent-uploaded_last_education_mark_list") private WebElement UploadEducationMarklist;
	@FindBy(id="bandhanstudent-uploaded_caste_certificate") private WebElement UploadCasteCertificate;
	@FindBy(id="bandhanstudent-uploaded_leaving_certificate") private WebElement UploadLeavingCertificate;
	@FindBy(id="bandhanstudent-uploaded_domicile_certificate") private WebElement UploadDomicileCertificate;
	@FindBy(id="bandhanstudent-uploaded_ration_card") private WebElement UploadRationCard;
	@FindBy(id="bandhanstudent-uploaded_driving_license") private WebElement UploadDrivingLicence;
	@FindBy(id="bandhanstudent-uploaded_passport") private WebElement UploadPassport;
	@FindBy(id="bandhanstudent-uploaded_light_bill") private WebElement UploadlightBill;
	@FindBy(id="bandhanstudent-uploaded_voter_id") private WebElement UploadVoterID;
	@FindBy(id="bandhanstudent-uploaded_income_certificate") private WebElement UploadIncomeCertificate;
	@FindBy(id="bandhanstudent-uploaded_disability_cirtificate") private WebElement UploadDisabilityCertificate;
	@FindBy(id="bandhanstudent-uploaded_resume") private WebElement UploadCV;
	
	//DOB Calendar locators
	@FindBy(xpath="//table[@class='table-condensed']//following-sibling::th") private WebElement MonthYearString;
	@FindBy(xpath="//table[@class='table-condensed']//following-sibling::tr/th[@class='prev']") private WebElement PrevButton;
	@FindBys({@FindBy(xpath ="//table[@class='table-condensed']//following-sibling::tbody//td")}) private List<WebElement> Days;
	
	//DOB calendar locators 2
	@FindBy(id="bandhanstudent-dob") private WebElement DOBCalender1;
	@FindBy(xpath="//table[@class='table-condensed']//following-sibling::th") private WebElement MonthYear1;
	
	//Language Multiselect dropdown
	@FindBy(xpath="(//input[@class='select2-search__field'])[3]") private WebElement selectLanguagesDD;
	@FindBys({@FindBy(xpath ="//ul[contains(@id,'language-results')]//li")}) private List<WebElement> languageOptions;
	
	
	
	
	public void ExpandBandhanAppDropDown() {
		wait.until(ExpectedConditions.visibilityOf(BandhanAppDD)).click();
	
	}
	
	public void locateAndClickOnAlumniOption() {
		for (int i = 0; i <= BandhanAppDDoptions.size(); i++) {
			WebElement option = BandhanAppDDoptions.get(i);
			if (option.getText().equalsIgnoreCase("Alumni")) {
				option.click();
				break;
			}
		}

	}
	
	public void clickonCreateBtn() {
		CreateAlumniBtn.click();
	}
	public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException {
//		FillCreateAlumniForm("CreateAlumni",0);
	}

	
	public void FillCreateAlumniForm(String SheetName, Integer RowNo) throws InvalidFormatException, IOException, InterruptedException {
		ExcelUtil eu=new ExcelUtil();
		eu.ExcelDataReader(SheetName, 0);
//		ExcelReader er = new ExcelReader();
//		List<Map<String, String>> TD = er.getData("src/main/java/TestData/Testdata.xlsx",SheetName );
		Thread.sleep(1000);
//		System.out.println(TD.get(RowNo).get("AlumniID"));
		AlumniID.sendKeys(ExcelUtil.AlumniID);
		FirstName.sendKeys(ExcelUtil.FirstName);
		LastName.sendKeys(ExcelUtil.LastName);
		Password.sendKeys(ExcelUtil.Password);
		ConfirmPassword.sendKeys(ExcelUtil.ConfirmPassword);
		CommanUtil.select(StateDD,ExcelUtil.StateDD);
		CommanUtil.select(DistrictDD,ExcelUtil.DistrictDD);
		Block.sendKeys(ExcelUtil.Block);
		
		
		PinCode.sendKeys(ExcelUtil.PinCode);
		SelectDOB(ExcelUtil.Day,ExcelUtil.Month,ExcelUtil.Year);
		CommanUtil.select(GenderDD,ExcelUtil.Gender);
		CommanUtil.select(EducationDD,ExcelUtil.Education);
		CommanUtil.select(PursuingEducationDD,ExcelUtil.Education);
		CommanUtil.select(PursuingEducationDD,ExcelUtil.PursuingEducation);
		CommanUtil.select(MartialStatusDD,ExcelUtil.MartialStatus);
		CommanUtil.select(DisabilityDD,ExcelUtil.Disability);
		CommanUtil.select(CenterDD,ExcelUtil.Center);
		CommanUtil.select(BatchDD,ExcelUtil.Batch);
		CommanUtil.select(FinancialYearDD,ExcelUtil.FinancialYear);
		EmailID.sendKeys(ExcelUtil.Email);
		MobileNo.sendKeys(ExcelUtil.MobileNo);
		CurrentAddress.sendKeys(ExcelUtil.CurrentAddress);
		selectSkill(ExcelUtil.Skills);
		Thread.sleep(100);
		selectmultipleLanguage();
		
		Thread.sleep(100);
		uploadDocument();
		
		
		
		
		
	}
	
	public void SelectDOB(String Day,String Month,String Year) throws InterruptedException {
		DOBCalender.click();
		Thread.sleep(2000);
		String MonthYear = MonthYearString.getText();
		String month = MonthYear.split(" ")[0].trim();
		String year=MonthYear.split(" ")[1].trim();
		
		while(!(month.equalsIgnoreCase(Month) && year.equalsIgnoreCase(Year))) {
			 PrevButton.click();
			 MonthYear = MonthYearString.getText();
			 month = MonthYear.split(" ")[0].trim();
			 year=MonthYear.split(" ")[1].trim();
		}
		
		for(int i=0;i<=Days.size();i++) {
			WebElement TempDay = Days.get(i);
			String ReqDay = TempDay.getText();
			if(ReqDay.equalsIgnoreCase(Day)) {
				TempDay.click();break;
			}
			}
		
		}
	
	
	public void selectSkill(String skill) {
		selectSkillsField.click();
		for(int i=0;i<SkillOptions.size();i++) {
			WebElement getSkill = SkillOptions.get(i);
			String ReqSkill = getSkill.getText();
			if(ReqSkill.equalsIgnoreCase(skill)) {
				getSkill.click();
			}
		}
		}
	
	
	
	
	public void uploadDocument() throws InterruptedException {
		String filepath="C:\\Projects\\BEES-yuva\\Testing Documents\\Images\\JPG extension\\upload.jpg";
		UploadAdhaar.sendKeys(filepath);
		UploadPan.sendKeys(filepath);
		UploadBirthCertificate.sendKeys(filepath);
		UploadEducationMarklist.sendKeys(filepath);
		UploadCasteCertificate.sendKeys(filepath);
		UploadLeavingCertificate.sendKeys(filepath);
		Thread.sleep(200);
		UploadDomicileCertificate.sendKeys(filepath);
		UploadRationCard.sendKeys(filepath);
		UploadDrivingLicence.sendKeys(filepath);
		UploadPassport.sendKeys(filepath);
		UploadlightBill.sendKeys(filepath);
		UploadVoterID.sendKeys(filepath);
		UploadIncomeCertificate.sendKeys(filepath);
		UploadDisabilityCertificate.sendKeys(filepath);
		UploadCV.sendKeys(filepath);
		UploadCV.sendKeys(filepath);
	}
	
	
	public void selectmultipleLanguage(){
		selectLanguagesDD.click();
		System.out.println(ExcelUtil.Languages);
		Actions action=new Actions(DriverFactory.getDriver());
		action.keyDown(Keys.CONTROL).build().perform();
		selectMultpleOptions(languageOptions,ExcelUtil.Languages);
		
		
		
	}

	public void selectMultpleOptions(List<WebElement> ele, String str) {
		String[] options = str.split(",");

		for (String option : options) {
			for (WebElement languageOption : languageOptions) {
				String languageText = languageOption.getText();
				if (languageText.equalsIgnoreCase(option)) {
					languageOption.click();
					break; // Exit the inner loop once the option is found and clicked
				}
			}
		}

	}
	
	//table[@class='table-condensed']//following-sibling::th=>Month and Year
	//span[contains(@class,'year')]=>Year
	//span[contains(@class,'month')]=>Month
	//th[@class='datepicker-switch']
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


