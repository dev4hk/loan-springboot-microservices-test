package runners.customer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Contract",
        plugin = {
                "html:reports/CustomerApplicationContractTest.html",
                "json:reports/CustomerApplicationContractTest.json",
        }
)
public class CustomerApplicationContractTest extends AbstractTestNGCucumberTests {
}
