package runners.manager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Terms",
        plugin = {
                "html:reports/ManagerTermsTest.html",
                "json:reports/ManagerTermsTest.json",
        }
)
public class ManagerTermsTest extends AbstractTestNGCucumberTests {
}
