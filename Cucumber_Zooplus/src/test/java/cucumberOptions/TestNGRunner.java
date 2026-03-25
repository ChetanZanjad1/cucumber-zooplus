package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature Files/FeatureFile1.feature", 
glue = "StepDefination", 
plugin = { 
		"pretty", 
		"html:target/cucumber-reports.html",
		"json:target/cucumber.json"
		},
monochrome = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
