package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/Jikan.feature", 					
		glue = "StepsDefinitions",
		tags = {"@Busqueda,@ValidarLinks"},
	    snippets = SnippetType.CAMELCASE
		)
public class JikanRunner{

}

