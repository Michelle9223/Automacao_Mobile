import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/Login.feature"},
				glue = {""},
				plugin = {"json:target/cucumber.json","html:target/Report-Login"},
			//	tags = {"@1"},
				monochrome = true)

public class LoginRunner extends AbstractTestNGCucumberTests{

}
