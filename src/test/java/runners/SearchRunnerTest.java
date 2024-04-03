package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		tags = "@Regression",
		monochrome = true,
		plugin = {
				"json:target/cucumber-reports.json",
				"pretty:target/cucumber-pretty.txt", 
				"junit:target/cucumber-results.xml"}, 
		snippets = SnippetType.CAMELCASE)
public class SearchRunnerTest {
}
