package runners.customer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@CustomerCounsel",
        plugin = {
                "html:reports/CustomerCounselTest.html",
                "json:reports/CustomerCounselTest.json",
        }
)
public class CustomerCounselTest extends AbstractTestNGCucumberTests {
}
