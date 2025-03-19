package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import page_objects.customer.CustomerApplicationPage;
import page_objects.customer.CustomerSummaryPage;
import utils.TestContext;

import java.util.List;

public class ApplicationStepDefinitions {

    TestContext testContext;
    CustomerSummaryPage customerSummaryPage;
    CustomerApplicationPage customerApplicationPage;

    public ApplicationStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("customer is on application page")
    public void customer_is_on_application_page() throws InterruptedException {
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
        this.customerSummaryPage.goToCustomerApplication();
        this.customerApplicationPage = this.testContext.getPageObjectManager().getCustomerApplicationPage();
        Thread.sleep(500);
        Assert.assertTrue(this.customerApplicationPage.getUrl().contains("/application"));
    }

    @Then("customer is able to see application form")
    public void customer_is_able_to_see_application_form() {
        Assert.assertTrue(this.customerApplicationPage.isFormDisplayed());
    }

    @When("customer fills out application form with data")
    public void customer_fills_out_application_form(List<String> data) {
        String cellPhone = data.get(0);
        String hopeAmount = data.get(1);
        this.customerApplicationPage.setCellPhone(cellPhone);
        this.customerApplicationPage.setHopeAmount(hopeAmount);
    }

    @When("customer clicks on application Submit button")
    public void customer_clicks_on_application_Submit_Button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) this.testContext.getTestBase().getDriver();
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(500);
        this.customerApplicationPage.submitApplication();
    }

    @Then("successful application creation message pops up")
    public void successful_application_creation_message_pops_up() {
        Assert.assertEquals(this.customerApplicationPage.getToastMessage(), "Application submitted successfully!");
    }

    @Then("application information is displayed with data")
    public void application_information_is_displayed_with_data(List<String> data) {
        Assert.assertTrue(this.customerApplicationPage.isDataDisplayed(data.get(0)));
        Assert.assertTrue(this.customerApplicationPage.isDataDisplayed(data.get(1)));
    }

    @When("customer agrees terms and submit")
    public void customer_agrees_terms_and_submit() {
        this.customerApplicationPage.checkTerms();
        this.customerApplicationPage.submitTerms();
    }

    @When("application FAQ question is clicked")
    public void application_faq_question_is_clicked() {
        this.customerApplicationPage.openFaqQuestion();
    }

    @Then("application FAQ answer is displayed")
    public void faq_answer_is_displayed() {
        Assert.assertTrue(this.customerApplicationPage.isFaqAnswerDisplayed());
    }


}
