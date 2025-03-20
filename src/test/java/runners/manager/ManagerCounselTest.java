package runners.manager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@ManagerCounsel"
)
public class ManagerCounselTest extends AbstractTestNGCucumberTests {
}
