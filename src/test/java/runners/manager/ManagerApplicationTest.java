package runners.manager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Manager and @Application and not @EntrySubmission",
        plugin = {
                "html:reports/ManagerApplicationTest.html",
                "json:reports/ManagerApplicationTest.json",
        }
)
public class ManagerApplicationTest extends AbstractTestNGCucumberTests {
}
