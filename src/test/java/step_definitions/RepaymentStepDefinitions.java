package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.customer.CustomerRepaymentPage;
import page_objects.customer.CustomerSummaryPage;
import utils.TestContext;

public class RepaymentStepDefinitions {
    TestContext testContext;
    CustomerSummaryPage customerSummaryPage;
    CustomerRepaymentPage customerRepaymentPage;

    public RepaymentStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("customer is on repayment page")
    public void customerIsOnRepaymentPage() {
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
        this.customerSummaryPage.goToCustomerRepayment();
        this.customerRepaymentPage = this.testContext.getPageObjectManager().getCustomerRepaymentPage();
    }

    @When("customer types monthly repayment amount")
    public void customerTypesMonthlyRepaymentAmount() {
        String monthlyAmount = this.customerRepaymentPage.getMonthlyPayment().substring(1);
        this.customerRepaymentPage.setPaymentInput(monthlyAmount);
    }

    @And("customer clicks on repayment Submit button")
    public void customerClicksOnRepaymentSubmitButton() throws InterruptedException {
        Assert.assertTrue(this.customerRepaymentPage.isPaymentAddedAfterSubmission());
    }

    @Then("repayment successful message pops up")
    public void repaymentSuccessfulMessagePopsUp() {
        Assert.assertEquals(this.customerRepaymentPage.getToastMessage(), "Repayment submitted successfully!");
    }

}


