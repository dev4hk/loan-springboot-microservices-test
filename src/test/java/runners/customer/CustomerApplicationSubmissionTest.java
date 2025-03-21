package runners.customer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Application and @Customer and not @Contract",
        plugin = {
                "html:reports/CustomerApplicationSubmissionTest.html",
                "json:reports/CustomerApplicationSubmissionTest.json",
        }
)
public class CustomerApplicationSubmissionTest extends AbstractTestNGCucumberTests {
}
