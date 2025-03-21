package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class CucumberHooks {

    private TestContext testContext;

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        WebDriver driver = this.testContext.getTestBase().getDriver();
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
    }

    @After
    public void afterScenario() {
        this.testContext.getTestBase().getDriver().quit();
    }
}