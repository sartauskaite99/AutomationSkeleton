package tietoevry.example.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to feature files
        glue = "tietoevry.example.automation",     // Path to step definitions, hooks
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Plugins for reporting
        monochrome = true  // Make console output more readable
)
public class TestRunner {
}
