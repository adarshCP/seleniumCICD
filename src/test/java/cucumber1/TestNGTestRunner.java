package cucumber1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber1",glue="rahulshetty.stepdefinitions",
monochrome =true,tags="@loginErrorValidation",plugin= {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	

}
