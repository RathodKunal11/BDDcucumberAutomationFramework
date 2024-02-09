package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/FeatureFiles",
					glue="StepDefinition",
					monochrome=true,	
					dryRun=false,
					plugin= {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
					
		)
public class TestRunnerTestNGTest extends AbstractTestNGCucumberTests{
	
	   @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

}	
