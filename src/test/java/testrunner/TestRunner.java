package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/reports/cucumber.html",
        },
        features = "src/test/resources/features",
        glue = {
                "stepdefinitions"
        }
)

public class TestRunner {
}
