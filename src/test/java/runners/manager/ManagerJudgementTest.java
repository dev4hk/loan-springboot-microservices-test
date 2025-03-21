package runners.manager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Judgement",
        plugin = {
                "html:reports/ManagerJudgementTest.html",
                "json:reports/ManagerJudgementTest.json",
        }
)
public class ManagerJudgementTest extends AbstractTestNGCucumberTests {
}
