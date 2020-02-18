import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        monochrome = false,
        format = { "pretty", "html:target/results" },
        glue = {"src/test/java/stepDefinitions", "src/test/java"},
        strict = true
       )

public class TestRunner {
}
