package runners.manager;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Manager and @Application and @EntrySubmission"
)
public class ManagerEntryTest {
}
