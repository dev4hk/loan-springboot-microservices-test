package runners.manager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Manager and @Application and @EntrySubmission",
        plugin = {
                "html:reports/ManagerEntryTest.html",
                "json:reports/ManagerEntryTest.json",
        }
)
public class ManagerEntryTest extends AbstractTestNGCucumberTests {
}
