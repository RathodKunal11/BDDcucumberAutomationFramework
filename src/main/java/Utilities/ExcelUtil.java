package Utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class ExcelUtil {
	private static String filepath="src/main/java/TestData/Testdata.xlsx";
	public static String AlumniID;
	public static String FirstName;
	public static String LastName;
	public static String Password;
	public static String ConfirmPassword;
	public static String StateDD;
	public static String DistrictDD;
	public static String Block;
	public static String PinCode;
	public static String Day;
	public static String Month;
	public static String Year;
	public static String Gender;
	public static String Education;
	public static String PursuingEducation;
	public static String MartialStatus;
	public static String Disability;
	public static String Center;
	public static String Batch;
	public static String FinancialYear;
	public static String Email;
	public static String MobileNo;
	public static String CurrentAddress;
	public static String Skills;
	public static String Languages;
	
	
	
	public void ExcelDataReader(String sheetname,int rownumner) throws InvalidFormatException, IOException {
		ExcelReader er = new ExcelReader();
		Map<String, String> TD = er.getData(filepath,sheetname).get(rownumner);
		AlumniID=TD.get("AlumniID");
		FirstName=TD.get("FirstName");
		LastName=TD.get("LastName");
		Password=TD.get("Password");
		ConfirmPassword=TD.get("ConfirmPassword");
		StateDD=TD.get("StateDD");
		DistrictDD=TD.get("DistrictDD");
		Block=TD.get("Block");
		PinCode=TD.get("PinCode");
		Day=TD.get("Day");
		Month=TD.get("Month");
		Year=TD.get("Year");
		Gender=TD.get("Gender");
		Education=TD.get("Education");
		PursuingEducation=TD.get("PursuingEducation");
		MartialStatus=TD.get("MartialStatus");
		Disability=TD.get("Disability");
		Center=TD.get("Center");
		Batch=TD.get("Batch");
		FinancialYear=TD.get("FinancialYear");
		Email=TD.get("Email");
		MobileNo=TD.get("MobileNo");
		CurrentAddress=TD.get("CurrentAddress");
		Skills=TD.get("Skills");
		Languages=TD.get("Languages");
		
	}	
}
