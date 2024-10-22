package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"}, // Step Definitions for Cucumber
        monochrome = true,          // Cleaner output in the console
        tags = "@regression",       // Tags to filter scenarios
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // ExtentReports Plugin
        }
)
public class Runner {
}
