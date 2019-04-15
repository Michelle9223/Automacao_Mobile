import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/Listagem.feature"},
				glue = {""},
				plugin = {"json:target/cucumber.json","html:target/Report-Listagem"},
			//	tags = {"@1"},
				monochrome = true)

public class ListagemRunner extends AbstractTestNGCucumberTests{

}
