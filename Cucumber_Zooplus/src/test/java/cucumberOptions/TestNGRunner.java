package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature Files/FeatureFile.feature", glue = "StepDefination", monochrome = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
