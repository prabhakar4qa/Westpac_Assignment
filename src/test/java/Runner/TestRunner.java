package Runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.java.*;
import utilities.Base;

 
@CucumberOptions(
		 features = {"src/main/java/features"}
        ,glue = {"stepDefinitions"}
        ,plugin = {"pretty","html:target/testme/buggy", "json:target/cucumber/cucumber1.json"}
		,monochrome=true
        ,dryRun=false
        ,tags = "@Buggy"
)

public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeMethod
	public void beforeScenario() 
	{
		Base.load_properties();
	}

	@AfterMethod
	public void afterScenario() 
	{
		Base.close_Browser();
	}
	
}