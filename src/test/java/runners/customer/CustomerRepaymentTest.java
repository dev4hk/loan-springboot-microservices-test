package runners.customer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        tags = "@Customer and @Repayment",
        plugin = {
                "html:reports/CustomerRepaymentTest.html",
                "json:reports/CustomerRepaymentTest.json",
        }
)
public class CustomerRepaymentTest extends AbstractTestNGCucumberTests {
}
